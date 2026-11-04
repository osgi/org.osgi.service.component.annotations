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

package org.osgi.test.cases.component.annotations.junit;

import static org.osgi.test.cases.component.annotations.junit.DescriptionXPathAssert.assertThat;

import org.junit.jupiter.api.Test;

/**
 * @author $Id$
 */
public class DS15AnnotationsTestCase extends AnnotationsTestCase {

	@Test
	public void testHelloWorld15() throws Exception {
		String name = testMethodName;
		Description description = descriptions.get(name);
		assertThat(description).as("component %s", name)
				.hasNamespace(xmlns_scr150)
				// v1.0.0
				.hasOptionalValue("@immediate", "true")
				.hasOptionalValue("@enabled", "true")
				.doesNotContain("@factory")
				.hasValue("implementation/@class",
						"org.osgi.impl.bundle.component.annotations."
								+ name.substring(4))
				.hasCount("implementation", 1)
				.hasCount("service", 0)
				.hasCount("reference", 0)
				// v1.1.0
				.hasOptionalValue("@configuration-policy", "optional")
				.hasOptionalValue("@activate", "activate")
				.hasOptionalValue("@deactivate", "deactivate")
				.hasValue("@modified", "modified")
				// v1.2.0
				.hasOptionalValue("@configuration-pid", name)
				// v1.3.0
				.hasOptionalValue("@scope", "singleton")
				// v1.4.0
				.doesNotContain("factory-property")
				.doesNotContain("factory-properties")
				.doesNotContain("@activation-fields")
				.doesNotContain("reference/@parameter")
				// v1.5.0
				// no new attributes/elements in this release but must test the
				// namespace and still compliant with 1.4
				;
	}

	@Test
	public void testReferences15() throws Exception {
		String name = testMethodName;
		Description description = descriptions.get(name);
		assertThat(description).as("component %s", name)
				.hasNamespace(xmlns_scr150)
				.hasCount("reference", 5)
				.hasValue("@init", "2")

				// AnyService
				.hasValue("reference[@name='anyField']/@interface",
						"org.osgi.service.component.AnyService")
				.hasValue("reference[@name='anyField']/@target",
						"(any.attr=foo)")
				.hasValue("reference[@name='anyField']/@field", "anyField")
				.hasValue("reference[@name='anyField']/@cardinality", "0..1")

				.hasValue("reference[@name='anyParam']/@interface",
						"org.osgi.service.component.AnyService")
				.hasValue("reference[@name='anyParam']/@target",
						"(any.attr=bar)")
				.hasValue("reference[@name='anyParam']/@parameter", "0")
				.hasValue("reference[@name='anyParam']/@cardinality", "0..1")
				.doesNotContain("reference[@name='anyParam']/@field")

				// Optional
				.hasValue("reference[@name='optionalField']/@interface",
						"java.util.EventListener")
				.hasValue("reference[@name='optionalField']/@field",
						"optionalField")
				.hasValue("reference[@name='optionalField']/@cardinality",
						"0..1")
				.hasOptionalValue(
						"reference[@name='optionalField']/@field-collection-type",
						"service")

				.hasValue("reference[@name='optionalMandatoryField']/@interface",
						"java.util.EventListener")
				.hasValue("reference[@name='optionalMandatoryField']/@field",
						"optionalMandatoryField")
				.hasOptionalValue(
						"reference[@name='optionalMandatoryField']/@cardinality",
						"1..1")
				.hasOptionalValue(
						"reference[@name='optionalMandatoryField']/@field-collection-type",
						"service")

				.hasValue("reference[@name='optionalParam']/@interface",
						"java.util.EventListener")
				.hasValue("reference[@name='optionalParam']/@parameter", "1")
				.hasValue("reference[@name='optionalParam']/@cardinality",
						"0..1")
				.hasOptionalValue(
						"reference[@name='optionalParam']/@field-collection-type",
						"service")
				.doesNotContain("reference[@name='optionalParam']/@field");
	}

	@Test
	public void testSatisfyingConditionTarget15() throws Exception {
		String name = testMethodName;
		Description description = descriptions.get(name);
		assertThat(description).as("component %s", name)
				.hasNamespace(xmlns_scr150)
				.hasCount("reference", 0)
				.hasPropertyValue("osgi.ds.satisfying.condition.target",
						"String", "(osgi.condition.id=custom)");
	}

	@Test
	public void testSatisfyingConditionDefault15() throws Exception {
		String name = testMethodName;
		Description description = descriptions.get(name);
		assertThat(description).as("component %s", name)
				.hasNamespace(xmlns_scr150)
				.hasCount("reference", 0)
				.hasPropertyValue("osgi.ds.satisfying.condition.target",
						"String", "(osgi.condition.id=true)");
	}

	@Test
	public void testAnyServiceMandatory15() throws Exception {
		String name = testMethodName;
		Description description = descriptions.get(name);
		assertThat(description).as("component %s", name)
				.hasNamespace(xmlns_scr150)
				.hasCount("reference", 1)
				.hasValue("reference[@name='any']/@interface",
						"org.osgi.service.component.AnyService")
				.hasValue("reference[@name='any']/@target",
						"(any.attr=mandatory)")
				.hasOptionalValue("reference[@name='any']/@cardinality",
						"1..1");
	}
}
