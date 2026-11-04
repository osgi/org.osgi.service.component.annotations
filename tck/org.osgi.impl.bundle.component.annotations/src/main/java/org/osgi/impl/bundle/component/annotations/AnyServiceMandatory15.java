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

import org.osgi.service.component.AnyService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * Mandatory reference to {@link AnyService}: the processor must not generate a
 * requirement for the AnyService type itself, only the target filter is
 * meaningful.
 */
@Component(name = "testAnyServiceMandatory15")
public class AnyServiceMandatory15 {

	@Reference(name = "any", service = AnyService.class, target = "(any.attr=mandatory)")
	private Object any;
}
