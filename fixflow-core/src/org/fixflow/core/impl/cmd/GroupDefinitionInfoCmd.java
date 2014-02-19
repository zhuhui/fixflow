/**
 * Copyright 1996-2013 Founder International Co.,Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * @author kenshin
 */
package org.fixflow.core.impl.cmd;

import java.util.List;

import org.fixflow.core.impl.Context;
import org.fixflow.core.impl.identity.GroupDefinition;
import org.fixflow.core.impl.interceptor.Command;
import org.fixflow.core.impl.interceptor.CommandContext;


public class GroupDefinitionInfoCmd implements Command<GroupDefinition> {

	protected String groupType;

	public GroupDefinitionInfoCmd(String groupType) {
		this.groupType = groupType;
	}

	public GroupDefinition execute(CommandContext commandContext) {

		List<GroupDefinition> groupDefinitions = Context.getProcessEngineConfiguration().getGroupDefinitions();
		for (GroupDefinition groupDefinition : groupDefinitions) {

			if (groupDefinition.getId().equals(this.groupType)) {
				return groupDefinition;
			}

		}
		return null;
	}

}