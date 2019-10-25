/******************************************************************************
 Copyright 2019 EMBL - European Bioinformatics Institute

 Licensed under the Apache License, Version 2.0 (the
 "License"); you may not use this file except in compliance
 with the License. You may obtain a copy of the License at
 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing,
 software distributed under the License is distributed on an
 "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 either express or implied. See the License for the specific
 language governing permissions and limitations under the
 License.
 */
package uk.ac.ebi.impc_prod_tracker.service.organization;

import uk.ac.ebi.impc_prod_tracker.data.organization.person.Person;
import java.util.List;

/**
 * Functionality to manage people in the system.
 */
public interface PersonService
{
    /**
     * Return a list of users that the logged user can see. If the logged user is a manager, they
     * can see all the users that can be managed by them. If the logged user is an admin they can
     * see all the users in the system.
     * @return List of {@link Person} with information about the people visible for the current
     * logged user.
     */
    List<Person> getAllPeople();
}
