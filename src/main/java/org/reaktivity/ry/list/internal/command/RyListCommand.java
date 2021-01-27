/**
 * Copyright 2016-2021 The Reaktivity Project
 *
 * The Reaktivity Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package org.reaktivity.ry.list.internal.command;

import org.reaktivity.nukleus.Configuration;
import org.reaktivity.nukleus.Nukleus;
import org.reaktivity.nukleus.NukleusFactory;
import org.reaktivity.ry.RyCommand;

import com.github.rvesse.airline.annotations.Command;

@Command(name = "list")
public final class RyListCommand extends RyCommand
{
    @Override
    public void run()
    {
        NukleusFactory factory = NukleusFactory.instantiate();
        Configuration config = new Configuration();
        for (String name : factory.names())
        {
            Nukleus nukleus = factory.create(name, config);
            System.out.format("%-10s %s\n", name, nukleus.getClass());
        }
    }
}
