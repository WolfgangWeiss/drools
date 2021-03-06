/*
 * Copyright 2010 JBoss Inc
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
 */

package org.drools.verifier.incoherence;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.drools.StatelessSession;
import org.drools.base.RuleNameMatchesAgendaFilter;
import org.drools.verifier.TestBaseOld;
import org.junit.Test;
import static org.junit.Assert.*;
import org.drools.verifier.components.VerifierRule;
import org.drools.verifier.data.VerifierReport;
import org.drools.verifier.data.VerifierReportFactory;
import org.drools.verifier.report.components.Severity;
import org.drools.verifier.report.components.VerifierMessage;
import org.drools.verifier.report.components.VerifierMessageBase;

public class IncoherentPatternsTest extends TestBaseOld {

    @Test
    public void testIncoherentPatternsInSubRule() throws Exception {
        StatelessSession session = getStatelessSession( this.getClass().getResourceAsStream( "Patterns.drl" ) );

        session.setAgendaFilter( new RuleNameMatchesAgendaFilter( "Incoherent Patterns in rule possibility" ) );

        VerifierReport result = VerifierReportFactory.newVerifierReport();
        Collection< ? extends Object> testData = getTestData( this.getClass().getResourceAsStream( "PatternsTest.drl" ),
                                                              result.getVerifierData() );

        session.setGlobal( "result",
                           result );

        session.executeWithResults( testData );

        Iterator<VerifierMessageBase> iter = result.getBySeverity( Severity.WARNING ).iterator();

        Set<String> rulesThatHadErrors = new HashSet<String>();
        while ( iter.hasNext() ) {
            Object o = (Object) iter.next();
            if ( o instanceof VerifierMessage ) {
                VerifierRule rule = (VerifierRule) ((VerifierMessage) o).getFaulty();
                rulesThatHadErrors.add( rule.getName() );
            }
        }

        assertTrue( rulesThatHadErrors.remove( "Incoherent patterns 1" ) );
        assertTrue( rulesThatHadErrors.remove( "Incoherent patterns 2" ) );
        assertTrue( rulesThatHadErrors.remove( "Incoherent patterns 7" ) );

        if ( !rulesThatHadErrors.isEmpty() ) {
            for ( String string : rulesThatHadErrors ) {
                fail( "Rule " + string + " caused an error." );
            }
        }
    }

    @Test
    public void testIncoherentPatternsInSubRuleVariables() throws Exception {
        StatelessSession session = getStatelessSession( this.getClass().getResourceAsStream( "Patterns.drl" ) );

        session.setAgendaFilter( new RuleNameMatchesAgendaFilter( "Incoherent Patterns in rule possibility, variables" ) );

        VerifierReport result = VerifierReportFactory.newVerifierReport();
        Collection< ? extends Object> testData = getTestData( this.getClass().getResourceAsStream( "PatternsTest.drl" ),
                                                              result.getVerifierData() );

        session.setGlobal( "result",
                           result );

        session.executeWithResults( testData );

        Iterator<VerifierMessageBase> iter = result.getBySeverity( Severity.WARNING ).iterator();

        Set<String> rulesThatHadErrors = new HashSet<String>();
        while ( iter.hasNext() ) {
            Object o = (Object) iter.next();
            if ( o instanceof VerifierMessage ) {
                VerifierRule rule = (VerifierRule) ((VerifierMessage) o).getFaulty();
                rulesThatHadErrors.add( rule.getName() );
            }
        }

        assertTrue( rulesThatHadErrors.remove( "Incoherent patterns 3" ) );
        assertTrue( rulesThatHadErrors.remove( "Incoherent patterns 4" ) );
        assertTrue( rulesThatHadErrors.remove( "Incoherent patterns 5" ) );
        assertTrue( rulesThatHadErrors.remove( "Incoherent patterns 6" ) );

        if ( !rulesThatHadErrors.isEmpty() ) {
            for ( String string : rulesThatHadErrors ) {
                fail( "Rule " + string + " caused an error." );
            }
        }
    }

    @Test
    public void testIncoherentPatternsInSubRuleRangesLess() throws Exception {
        StatelessSession session = getStatelessSession( this.getClass().getResourceAsStream( "Patterns.drl" ) );

        session.setAgendaFilter( new RuleNameMatchesAgendaFilter( "Incoherent Patterns in rule possibility, ranges when not conflicts with lesser value" ) );

        VerifierReport result = VerifierReportFactory.newVerifierReport();
        Collection< ? extends Object> testData = getTestData( this.getClass().getResourceAsStream( "PatternsTest.drl" ),
                                                              result.getVerifierData() );

        session.setGlobal( "result",
                           result );

        session.executeWithResults( testData );

        Iterator<VerifierMessageBase> iter = result.getBySeverity( Severity.WARNING ).iterator();

        Set<String> rulesThatHadErrors = new HashSet<String>();
        while ( iter.hasNext() ) {
            Object o = (Object) iter.next();
            if ( o instanceof VerifierMessage ) {
                VerifierRule rule = (VerifierRule) ((VerifierMessage) o).getFaulty();
                rulesThatHadErrors.add( rule.getName() );
            }
        }

        assertTrue( rulesThatHadErrors.remove( "Incoherent patterns 8" ) );
        assertTrue( rulesThatHadErrors.remove( "Incoherent patterns 12" ) );

        if ( !rulesThatHadErrors.isEmpty() ) {
            for ( String string : rulesThatHadErrors ) {
                fail( "Rule " + string + " caused an error." );
            }
        }
    }

    @Test
    public void testIncoherentPatternsInSubRuleRangesGreater() throws Exception {
        StatelessSession session = getStatelessSession( this.getClass().getResourceAsStream( "Patterns.drl" ) );

        session.setAgendaFilter( new RuleNameMatchesAgendaFilter( "Incoherent Patterns in rule possibility, ranges when not conflicts with greater value" ) );

        VerifierReport result = VerifierReportFactory.newVerifierReport();
        Collection< ? extends Object> testData = getTestData( this.getClass().getResourceAsStream( "PatternsTest.drl" ),
                                                              result.getVerifierData() );

        session.setGlobal( "result",
                           result );

        session.executeWithResults( testData );

        Iterator<VerifierMessageBase> iter = result.getBySeverity( Severity.WARNING ).iterator();

        Set<String> rulesThatHadErrors = new HashSet<String>();
        while ( iter.hasNext() ) {
            Object o = (Object) iter.next();
            if ( o instanceof VerifierMessage ) {
                VerifierRule rule = (VerifierRule) ((VerifierMessage) o).getFaulty();
                rulesThatHadErrors.add( rule.getName() );
            }
        }

        assertTrue( rulesThatHadErrors.remove( "Incoherent patterns 9" ) );
        assertTrue( rulesThatHadErrors.remove( "Incoherent patterns 14" ) );

        if ( !rulesThatHadErrors.isEmpty() ) {
            for ( String string : rulesThatHadErrors ) {
                fail( "Rule " + string + " caused an error." );
            }
        }
    }

    @Test
    public void testIncoherentPatternsInSubRuleRangesEqualOrUnequal() throws Exception {
        StatelessSession session = getStatelessSession( this.getClass().getResourceAsStream( "Patterns.drl" ) );

        session.setAgendaFilter( new RuleNameMatchesAgendaFilter( "Incoherent Patterns in rule possibility, ranges when not conflicts with equal or unequal value" ) );

        VerifierReport result = VerifierReportFactory.newVerifierReport();
        Collection< ? extends Object> testData = getTestData( this.getClass().getResourceAsStream( "PatternsTest.drl" ),
                                                              result.getVerifierData() );

        session.setGlobal( "result",
                           result );

        session.executeWithResults( testData );

        Iterator<VerifierMessageBase> iter = result.getBySeverity( Severity.WARNING ).iterator();

        Set<String> rulesThatHadErrors = new HashSet<String>();
        while ( iter.hasNext() ) {
            Object o = (Object) iter.next();
            if ( o instanceof VerifierMessage ) {
                VerifierRule rule = (VerifierRule) ((VerifierMessage) o).getFaulty();
                rulesThatHadErrors.add( rule.getName() );
            }
        }

        assertTrue( rulesThatHadErrors.remove( "Incoherent patterns 10" ) );
        assertTrue( rulesThatHadErrors.remove( "Incoherent patterns 15" ) );

        if ( !rulesThatHadErrors.isEmpty() ) {
            for ( String string : rulesThatHadErrors ) {
                fail( "Rule " + string + " caused an error." );
            }
        }
    }

    @Test
    public void testIncoherentPatternsInSubRuleRangesEqualOrUnequalVariables() throws Exception {
        StatelessSession session = getStatelessSession( this.getClass().getResourceAsStream( "Patterns.drl" ) );

        session.setAgendaFilter( new RuleNameMatchesAgendaFilter( "Incoherent Patterns in rule possibility, ranges when not conflicts with equal or unequal variables" ) );

        VerifierReport result = VerifierReportFactory.newVerifierReport();
        Collection< ? extends Object> testData = getTestData( this.getClass().getResourceAsStream( "PatternsTest.drl" ),
                                                              result.getVerifierData() );

        session.setGlobal( "result",
                           result );

        session.executeWithResults( testData );

        Iterator<VerifierMessageBase> iter = result.getBySeverity( Severity.WARNING ).iterator();

        Set<String> rulesThatHadErrors = new HashSet<String>();
        while ( iter.hasNext() ) {
            Object o = (Object) iter.next();
            if ( o instanceof VerifierMessage ) {
                VerifierRule rule = (VerifierRule) ((VerifierMessage) o).getFaulty();
                rulesThatHadErrors.add( rule.getName() );
            }
        }

        assertTrue( rulesThatHadErrors.remove( "Incoherent patterns 11" ) );

        if ( !rulesThatHadErrors.isEmpty() ) {
            for ( String string : rulesThatHadErrors ) {
                fail( "Rule " + string + " caused an error." );
            }
        }
    }

    @Test
    public void testIncoherentPatternsInSubRuleRangesEqualValue() throws Exception {
        StatelessSession session = getStatelessSession( this.getClass().getResourceAsStream( "Patterns.drl" ) );

        session.setAgendaFilter( new RuleNameMatchesAgendaFilter( "Incoherent Patterns in rule possibility, ranges when not conflicts with equal value" ) );

        VerifierReport result = VerifierReportFactory.newVerifierReport();
        Collection< ? extends Object> testData = getTestData( this.getClass().getResourceAsStream( "PatternsTest.drl" ),
                                                              result.getVerifierData() );

        session.setGlobal( "result",
                           result );

        session.executeWithResults( testData );

        Iterator<VerifierMessageBase> iter = result.getBySeverity( Severity.WARNING ).iterator();

        Set<String> rulesThatHadErrors = new HashSet<String>();
        while ( iter.hasNext() ) {
            Object o = (Object) iter.next();
            if ( o instanceof VerifierMessage ) {
                VerifierRule rule = (VerifierRule) ((VerifierMessage) o).getFaulty();
                rulesThatHadErrors.add( rule.getName() );
            }
        }

        assertTrue( rulesThatHadErrors.remove( "Incoherent patterns 16" ) );

        if ( !rulesThatHadErrors.isEmpty() ) {
            for ( String string : rulesThatHadErrors ) {
                fail( "Rule " + string + " caused an error." );
            }
        }
    }

    @Test
    public void testIncoherentPatternsInSubRuleRangesEqualVariable() throws Exception {
        StatelessSession session = getStatelessSession( this.getClass().getResourceAsStream( "Patterns.drl" ) );

        session.setAgendaFilter( new RuleNameMatchesAgendaFilter( "Incoherent Patterns in rule possibility, ranges when not conflicts with equal variable" ) );

        VerifierReport result = VerifierReportFactory.newVerifierReport();
        Collection< ? extends Object> testData = getTestData( this.getClass().getResourceAsStream( "PatternsTest.drl" ),
                                                              result.getVerifierData() );

        session.setGlobal( "result",
                           result );

        session.executeWithResults( testData );

        Iterator<VerifierMessageBase> iter = result.getBySeverity( Severity.WARNING ).iterator();

        Set<String> rulesThatHadErrors = new HashSet<String>();
        while ( iter.hasNext() ) {
            Object o = (Object) iter.next();
            if ( o instanceof VerifierMessage ) {
                VerifierRule rule = (VerifierRule) ((VerifierMessage) o).getFaulty();
                rulesThatHadErrors.add( rule.getName() );
            }
        }

        assertTrue( rulesThatHadErrors.remove( "Incoherent patterns 13" ) );

        if ( !rulesThatHadErrors.isEmpty() ) {
            for ( String string : rulesThatHadErrors ) {
                fail( "Rule " + string + " caused an error." );
            }
        }
    }
}
