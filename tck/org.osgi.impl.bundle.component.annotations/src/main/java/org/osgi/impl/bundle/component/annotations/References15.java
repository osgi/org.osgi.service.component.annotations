/*******************************************************************************
 * Copyright (c) Contributors to the Eclipse Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0 
 *******************************************************************************/

package org.osgi.impl.bundle.component.annotations;

import java.util.EventListener;
import java.util.Optional;

import org.osgi.service.component.AnyService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

@Component(name = "testReferences15")
public class References15 {

	@Reference(name = "anyField", service = AnyService.class, cardinality = ReferenceCardinality.OPTIONAL, target = "(any.attr=foo)")
	private Object							anyField;

	@Reference(name = "optionalField")
	private Optional<EventListener>			optionalField;

	@Reference(name = "optionalMandatoryField", cardinality = ReferenceCardinality.MANDATORY)
	private Optional<EventListener>			optionalMandatoryField;

	@Activate
	public References15(
			@Reference(name = "anyParam", service = AnyService.class, cardinality = ReferenceCardinality.OPTIONAL, target = "(any.attr=bar)") Object anyParam,
			@Reference(name = "optionalParam") Optional<EventListener> optionalParam) {
		/**/
	}
}
