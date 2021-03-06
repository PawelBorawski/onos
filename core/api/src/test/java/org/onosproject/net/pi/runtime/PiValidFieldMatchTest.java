/*
 * Copyright 2017-present Open Networking Foundation
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
 */

package org.onosproject.net.pi.runtime;

import com.google.common.testing.EqualsTester;
import org.junit.Test;
import org.onosproject.net.pi.model.PiMatchType;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.onlab.junit.ImmutableClassChecker.assertThatClassIsImmutable;
import static org.onosproject.net.pi.runtime.PiConstantsTest.VID;
import static org.onosproject.net.pi.runtime.PiConstantsTest.VLAN_HEADER_NAME;

/**
 * Unit tests for PiValidFieldMatch class.
 */
public class PiValidFieldMatchTest {

    final boolean isValid1 = true;
    final boolean isValid2 = false;
    final PiHeaderFieldId piHeaderField = PiHeaderFieldId.of(VLAN_HEADER_NAME, VID);
    PiValidFieldMatch piValidFieldMatch1 = new PiValidFieldMatch(piHeaderField, isValid1);
    PiValidFieldMatch sameAsPiValidFieldMatch1 = new PiValidFieldMatch(piHeaderField, isValid1);
    PiValidFieldMatch piValidFieldMatch2 = new PiValidFieldMatch(piHeaderField, isValid2);

    /**
     * Checks that the PiValidFieldMatch class is immutable.
     */
    @Test
    public void testImmutability() {
        assertThatClassIsImmutable(PiValidFieldMatch.class);
    }

    /**
     * Checks the operation of equals(), hashCode() and toString() methods.
     */
    @Test
    public void testEquals() {
        new EqualsTester()
                .addEqualityGroup(piValidFieldMatch1, sameAsPiValidFieldMatch1)
                .addEqualityGroup(piValidFieldMatch2)
                .testEquals();
    }

    /**
     * Checks the construction of a PiValidFieldMatch object.
     */
    @Test
    public void testConstruction() {
        final boolean isValid = true;
        final PiHeaderFieldId piHeaderField = PiHeaderFieldId.of(VLAN_HEADER_NAME, VID);
        PiValidFieldMatch piTernaryFieldMatch = new PiValidFieldMatch(piHeaderField, isValid);
        assertThat(piTernaryFieldMatch, is(notNullValue()));
        assertThat(piTernaryFieldMatch.isValid(), is(isValid));
        assertThat(piTernaryFieldMatch.type(), is(PiMatchType.VALID));
    }
}
