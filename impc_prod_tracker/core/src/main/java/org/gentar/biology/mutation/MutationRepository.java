/*******************************************************************************
 * Copyright 2019 EMBL - European Bioinformatics Institute
 *
 * Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific
 * language governing permissions and limitations under the
 * License.
 *******************************************************************************/
package org.gentar.biology.mutation;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MutationRepository extends CrudRepository<Mutation, Long>
{
    @Query("SELECT max(m.min) FROM Mutation m")
    String getMaxMin();

    Mutation findFirstById(Long id);

    Mutation findByMin(String min);

    List<Mutation> findAllBySymbolLike(String symbolSearchTerm);

    @Query("select m.id as mutationId, g.id as geneId, g as gene from Mutation m LEFT OUTER JOIN m.genes g")
    List<MutationGeneProjection> findAllMutationGeneProjections();

    @Query("select m.id as mutationId, g.id as geneId, g as gene from Mutation m LEFT OUTER JOIN m.genes g where m.id IN :id")
    List<MutationGeneProjection> findSelectedMutationGeneProjections(@Param("id") List mutationIds);
}
