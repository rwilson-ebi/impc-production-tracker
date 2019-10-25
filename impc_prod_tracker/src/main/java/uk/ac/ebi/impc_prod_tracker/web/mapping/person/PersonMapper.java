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
package uk.ac.ebi.impc_prod_tracker.web.mapping.person;

import org.springframework.stereotype.Component;
import uk.ac.ebi.impc_prod_tracker.data.organization.person.Person;
import uk.ac.ebi.impc_prod_tracker.data.organization.person_role_consortium.PersonRoleConsortium;
import uk.ac.ebi.impc_prod_tracker.data.organization.person_role_work_unit.PersonRoleWorkUnit;
import uk.ac.ebi.impc_prod_tracker.service.conf.PermissionService;
import uk.ac.ebi.impc_prod_tracker.web.dto.person.PersonDTO;
import uk.ac.ebi.impc_prod_tracker.web.dto.person.PersonRoleConsortiumDTO;
import uk.ac.ebi.impc_prod_tracker.web.dto.person.PersonRoleWorkUnitDTO;
import uk.ac.ebi.impc_prod_tracker.web.mapping.EntityMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class PersonMapper
{
    private EntityMapper entityMapper;
    private PermissionService permissionService;

    public PersonMapper(EntityMapper entityMapper, PermissionService permissionService)
    {
        this.entityMapper = entityMapper;
        this.permissionService = permissionService;
    }

    public PersonDTO toDto(Person person)
    {
        PersonDTO personDTO = entityMapper.toTarget(person, PersonDTO.class);
        personDTO.setRolesWorkUnits(peopleRoleWorkUnitToDtos(person.getRoleWorkUnits()));
        personDTO.setRolesConsortia(peopleRoleConsortiaToDto(person.getRoleConsortia()));
        personDTO.setActionPermissions(permissionService.getPermissions());
        return personDTO;
    }

    public List<PersonDTO> toDtos(Collection<Person> people)
    {
        List<PersonDTO> personDTOS = new ArrayList<>();
        if (people != null)
        {
            people.forEach(x -> personDTOS.add(toDto(x)));
        }
        return personDTOS;
    }

    private PersonRoleWorkUnitDTO personRoleWorkUnitToDto(PersonRoleWorkUnit personRoleWorkUnit)
    {
        return entityMapper.toTarget(personRoleWorkUnit, PersonRoleWorkUnitDTO.class);
    }

    private List<PersonRoleWorkUnitDTO> peopleRoleWorkUnitToDtos(
        Collection<PersonRoleWorkUnit> peopleRoleWorkUnit)
    {
        return entityMapper.toTargets(peopleRoleWorkUnit, PersonRoleWorkUnitDTO.class);
    }

    private PersonRoleConsortiumDTO personRoleConsortiumToDto(PersonRoleConsortium personRoleConsortium)
    {
        return entityMapper.toTarget(personRoleConsortium, PersonRoleConsortiumDTO.class);
    }

    private List<PersonRoleConsortiumDTO> peopleRoleConsortiaToDto(
        Collection<PersonRoleConsortium> peopleRoleConsortia)
    {
        return entityMapper.toTargets(peopleRoleConsortia, PersonRoleConsortiumDTO.class);
    }
}
