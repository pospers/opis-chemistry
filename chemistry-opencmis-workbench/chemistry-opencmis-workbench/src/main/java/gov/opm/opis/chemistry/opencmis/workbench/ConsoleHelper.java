/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package gov.opm.opis.chemistry.opencmis.workbench;

import groovy.console.ui.Console;
import groovy.lang.Binding;
import groovy.util.GroovyScriptEngine;
import gov.opm.opis.chemistry.opencmis.client.api.Session;
import gov.opm.opis.chemistry.opencmis.commons.SessionParameter;
import gov.opm.opis.chemistry.opencmis.commons.impl.IOUtils;
import gov.opm.opis.chemistry.opencmis.workbench.ClientHelper.FileEntry;
import gov.opm.opis.chemistry.opencmis.workbench.model.ClientModel;
import gov.opm.opis.chemistry.opencmis.workbench.model.ClientSession;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultEditorKit;
import java.awt.*;
import java.awt.Desktop.Action;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URI;
import java.util.Collections;
import java.util.List;

public class ConsoleHelper {

    private static final String SYSPROP_SCRIPTS = ClientSession.WORKBENCH_PREFIX + "scripts";
    private static final String SYSPROP_SNIPPETS = ClientSession.WORKBENCH_PREFIX + "snippets";

    private static final String GROOVY_SCRIPT_FOLDER = "/scripts/";
    private static final String GROOVY_SCRIPT_LIBRARY = "script-library.properties";
    private static final String GROOVY_SNIPPET_FOLDER = "/snippets/";
    private static final String GROOVY_SNIPPET_LIBRARY = "snippet-library.properties";

    /**
     * Open a Groovy console and load the script from the provided file.
     */
    public static Console openConsole(final Component parent, final ClientModel model, final URI file) {
        return openConsole(parent, model, file, null);
    }

    /**
     * Open a Groovy console and use the provided.
     */
    public static Console openConsole(final Component parent, final ClientModel model, final String soureCode) {
        return openConsole(parent, model, null, soureCode);
    }

    private static Console openConsole(final Component parent, final ClientModel model, final URI file,
            final String soureCode) {
        try {
            parent.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

            final Session groovySession = model.getClientSession().getSession();
            final String user = model.getClientSession().getSessionParameters().get(SessionParameter.USER);

            final Console console = new Console(parent.getClass().getClassLoader());

            console.setVariable("session", groovySession);
            console.setVariable("binding", groovySession.getBinding());

            console.run();

            // add menu
            JMenuBar consoleMenuBar = console.getFrame().getRootPane().getJMenuBar();

            JMenu cmisMenu = new JMenu("CMIS");
            cmisMenu.setMnemonic(KeyEvent.VK_M);
            consoleMenuBar.add(cmisMenu);

            addConsoleMenu(cmisMenu, "CMIS 1.0 Specification",
                    new URI("https://docs.oasis-open.org/cmis/CMIS/v1.0/os/cmis-spec-v1.0.html"));
            addConsoleMenu(cmisMenu, "CMIS 1.1 Specification",
                    new URI("https://docs.oasis-open.org/cmis/CMIS/v1.1/CMIS-v1.1.html"));
            cmisMenu.addSeparator();
            addConsoleMenu(cmisMenu, "OpenCMIS Documentation",
                    new URI("https://chemistry.apache.org/java/opencmis.html"));
            addConsoleMenu(cmisMenu, "OpenCMIS Code Samples",
                    new URI("https://chemistry.apache.org/docs/cmis-samples/"));
            addConsoleMenu(cmisMenu, "OpenCMIS Client API JavaDoc",
                    new URI("https://chemistry.apache.org/java/javadoc/"));
            cmisMenu.addSeparator();
            JMenuItem menuItem = new JMenuItem("CMIS Session Details");
            menuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    AttributeSet style = console.getOutputStyle();
                    console.clearOutput();
                    console.appendOutputNl("Session ID:      " + groovySession.getBinding().getSessionId(), style);
                    console.appendOutputNl("Repository ID:   " + groovySession.getRepositoryInfo().getId(), style);
                    console.appendOutputNl("Repository name: " + groovySession.getRepositoryInfo().getName(), style);
                    console.appendOutputNl("Binding:         " + groovySession.getBinding().getBindingType(), style);
                    console.appendOutputNl("User:            " + user, style);
                }
            });
            cmisMenu.add(menuItem);

            JMenu snippetsMenu = new JMenu("Snippets");
            snippetsMenu.setMnemonic(KeyEvent.VK_N);
            consoleMenuBar.add(snippetsMenu);

            // add 'copy repository id' menu item

            JSeparator jSeparator = new JSeparator(JSeparator.VERTICAL);
            int prefMenuBarHeight = (int) console.getFrame().getRootPane().getJMenuBar().getPreferredSize().getHeight();
            jSeparator.setMaximumSize(new Dimension(20, prefMenuBarHeight));
            consoleMenuBar.add(jSeparator);

            String repoIdItemLabel = "Repository ID: " + groovySession.getRepositoryInfo().getId();
            JMenuItem repoIdItem = new JMenuItem(repoIdItemLabel);
            repoIdItem.setFont(repoIdItem.getFont().deriveFont(Font.BOLD, repoIdItem.getFont().getSize()));
            repoIdItem.setToolTipText("Click to copy repository ID to clipboard");
            repoIdItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                    clipboard.setContents(new StringSelection(groovySession.getRepositoryInfo().getId()), null);
                }
            });
            consoleMenuBar.add(repoIdItem);

            // add snippet menu

            for (FileEntry entry : readSnippetLibrary()) {
                String snippet = ClientHelper.readFileAndRemoveHeader(entry.getFile());

                JMenuItem snippetItem = new JMenuItem(entry.getName());
                snippetItem.addActionListener(new ConsoleInsertActionListener(console, snippet));
                snippetsMenu.add(snippetItem);
            }

            // add popup menu

            final JPopupMenu popup = new JPopupMenu();

            final JMenuItem cutItem = new JMenuItem(new DefaultEditorKit.CutAction());
            cutItem.setText("Cut");
            popup.add(cutItem);

            final JMenuItem copyItem = new JMenuItem(new DefaultEditorKit.CopyAction());
            copyItem.setText("Copy");
            popup.add(copyItem);

            final JMenuItem pasteItem = new JMenuItem(new DefaultEditorKit.PasteAction());
            pasteItem.setText("Paste");
            popup.add(pasteItem);

            console.getInputArea().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    maybeShowPopup(e);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    maybeShowPopup(e);
                }

                private void maybeShowPopup(MouseEvent e) {
                    if (e.isPopupTrigger()) {
                        if (console.getInputArea().getSelectedText() != null) {
                            cutItem.setEnabled(true);
                            copyItem.setEnabled(true);

                        } else {
                            cutItem.setEnabled(false);
                            copyItem.setEnabled(false);
                        }

                        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                        pasteItem.setEnabled(clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor));

                        popup.show(e.getComponent(), e.getX(), e.getY());
                    }
                }
            });

            // read source code
            if (file != null) {
                console.getInputArea().setText(ClientHelper.readFileAndRemoveHeader(file));
            } else if (soureCode != null) {
                console.getInputArea().setText(soureCode);
            }

            return console;
        } catch (Exception ex) {
            ClientHelper.showError(null, ex);
            return null;
        } finally {
            parent.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }
    }

    private static void addConsoleMenu(JMenu menu, String title, final URI url) {
        if (!Desktop.isDesktopSupported() || !Desktop.getDesktop().isSupported(Action.BROWSE)) {
            return;
        }

        JMenuItem menuItem = new JMenuItem(title);
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(url);
                } catch (IOException ex) {
                    ClientHelper.showError(null, ex);
                }
            }
        });

        menu.add(menuItem);
    }

    public static List<FileEntry> readScriptLibrary() {
        URI propFile = null;

        String externalScripts = System.getProperty(SYSPROP_SCRIPTS);
        if (externalScripts == null) {
            propFile = ClientHelper.getClasspathURI(GROOVY_SCRIPT_FOLDER + GROOVY_SCRIPT_LIBRARY);
        } else {
            propFile = (new File(externalScripts)).toURI();
        }

        List<FileEntry> result = ClientHelper.readFileProperties(propFile);

        if (result == null || result.isEmpty()) {
            result = Collections.singletonList(new FileEntry("Groovy Console", null));
        }

        return result;
    }

    public static List<FileEntry> readSnippetLibrary() {
        URI propFile = null;

        String externalSnippets = System.getProperty(SYSPROP_SNIPPETS);
        if (externalSnippets == null) {
            propFile = ClientHelper.getClasspathURI(GROOVY_SNIPPET_FOLDER + GROOVY_SNIPPET_LIBRARY);
        } else {
            propFile = (new File(externalSnippets)).toURI();
        }

        List<FileEntry> result = ClientHelper.readFileProperties(propFile);

        if (result == null) {
            result = Collections.emptyList();
        }

        return result;
    }

    public static void runGroovyScript(final Component parent, final ClientModel model, final File file,
            final Writer out) {
        try {
            parent.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

            String[] roots = new String[] { file.getParentFile().getAbsolutePath() };
            GroovyScriptEngine gse = new GroovyScriptEngine(roots, parent.getClass().getClassLoader());
            Binding binding = new Binding();
            binding.setVariable("session", model.getClientSession().getSession());
            binding.setVariable("binding", model.getClientSession().getSession().getBinding());
            binding.setVariable("out", out);
            gse.run(file.getName(), binding);
        } catch (Exception ex) {
            ClientHelper.showError(null, ex);
        } finally {
            parent.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }
    }

    public static void runJSR223Script(final Component parent, final ClientModel model, final File file,
            final String ext, final Writer out) {
        InputStreamReader reader = null;
        try {
            parent.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

            reader = new InputStreamReader(new FileInputStream(file), IOUtils.UTF8);

            ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine engine = mgr.getEngineByExtension(ext);
            engine.getContext().setWriter(out);
            engine.getContext().setErrorWriter(out);
            engine.put("session", model.getClientSession().getSession());
            engine.put("binding", model.getClientSession().getSession().getBinding());
            engine.put("out", new PrintWriter(out));
            engine.eval(reader);
        } catch (Exception ex) {
            ClientHelper.showError(null, ex);
        } finally {
            IOUtils.closeQuietly(reader);
            parent.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }
    }

    // ---

    private static class ConsoleInsertActionListener implements ActionListener {
        private final Console console;
        private final String snippet;

        public ConsoleInsertActionListener(Console console, String snippet) {
            this.console = console;
            this.snippet = snippet;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int start = console.getInputArea().getSelectionStart();
                int end = console.getInputArea().getSelectionEnd();
                if (end - start > 0) {
                    console.getInputArea().getDocument().remove(start, end - start);
                }
                console.getInputArea().getDocument().insertString(console.getInputArea().getCaretPosition(), snippet,
                        null);
            } catch (BadLocationException ex) {
                ClientHelper.showError(console.getFrame().getRootPane(), ex);
            }
        }
    }
}
