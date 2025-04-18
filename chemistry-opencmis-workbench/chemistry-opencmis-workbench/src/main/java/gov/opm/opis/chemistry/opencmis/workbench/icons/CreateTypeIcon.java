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
package gov.opm.opis.chemistry.opencmis.workbench.icons;

import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

public class CreateTypeIcon extends AbstractWorkbenchIcon {

    public CreateTypeIcon() {
        super();
    }

    public CreateTypeIcon(int width, int height) {
        super(width, height);
    }

    public CreateTypeIcon(int width, int height, boolean enabled) {
        super(width, height, enabled);
    }

    @Override
    protected int getOrginalHeight() {
        return 64;
    }

    @Override
    protected int getOrginalWidth() {
        return 64;
    }

    @Override
    protected void paint(Graphics2D g) {
        GeneralPath shape = new GeneralPath();

        shape.moveTo(19.0, 35.0);
        shape.lineTo(29.0, 35.0);
        shape.lineTo(29.0, 45.0);
        shape.curveTo(29.0, 46.657, 30.343, 48.0, 32.0, 48.0);
        shape.curveTo(33.656998, 48.0, 35.0, 46.657, 35.0, 45.0);
        shape.lineTo(35.0, 35.0);
        shape.lineTo(45.0, 35.0);
        shape.curveTo(46.657, 35.0, 48.0, 33.657, 48.0, 32.0);
        shape.curveTo(48.0, 30.342999, 46.657, 29.0, 45.0, 29.0);
        shape.lineTo(35.0, 29.0);
        shape.lineTo(35.0, 19.0);
        shape.curveTo(35.0, 17.343, 33.657, 16.0, 32.0, 16.0);
        shape.curveTo(30.342999, 16.0, 29.0, 17.343, 29.0, 19.0);
        shape.lineTo(29.0, 29.0);
        shape.lineTo(19.0, 29.0);
        shape.curveTo(17.343, 29.0, 16.0, 30.343, 16.0, 32.0);
        shape.curveTo(16.0, 33.656998, 17.343, 35.0, 19.0, 35.0);
        shape.closePath();
        shape.moveTo(61.0, 0.0);
        shape.lineTo(3.0, 0.0);
        shape.curveTo(1.343, 0.0, 0.0, 1.343, 0.0, 3.0);
        shape.lineTo(0.0, 61.0);
        shape.curveTo(0.0, 62.657, 1.343, 64.0, 3.0, 64.0);
        shape.lineTo(61.0, 64.0);
        shape.curveTo(62.657, 64.0, 64.0, 62.657, 64.0, 61.0);
        shape.lineTo(64.0, 3.0);
        shape.curveTo(64.0, 1.343, 62.657, 0.0, 61.0, 0.0);
        shape.closePath();
        shape.moveTo(58.0, 58.0);
        shape.lineTo(6.0, 58.0);
        shape.lineTo(6.0, 6.0);
        shape.lineTo(58.0, 6.0);
        shape.lineTo(58.0, 58.0);
        shape.closePath();

        g.setPaint(getColor());
        g.fill(shape);
    }
}
