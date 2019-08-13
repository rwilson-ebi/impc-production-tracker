package uk.ac.ebi.impc_prod_tracker.web.mapping.plan.production_plan;

import org.springframework.stereotype.Component;
import uk.ac.ebi.impc_prod_tracker.data.biology.attempt.AttemptRepository;
import uk.ac.ebi.impc_prod_tracker.web.mapping.plan.production_plan.attempt.crispr_attempt.CrisprAttemptDTOBuilder;

@Component
public class ProductionPlanDTOBuilder
{
    private AttemptRepository attemptRepository;
    private CrisprAttemptDTOBuilder crisprAttemptDTOBuilder;
    private static final String CRISPR_MUTAGENESIS_TYPE_NAME = "CRISPR_mutagenesis";

    public ProductionPlanDTOBuilder(
        AttemptRepository attemptRepository, CrisprAttemptDTOBuilder crisprAttemptDTOBuilder)
    {
        this.attemptRepository = attemptRepository;
        this.crisprAttemptDTOBuilder = crisprAttemptDTOBuilder;
    }

//    public ProductionPlanDTO buildProductionPlanDTOFromPlan(final Plan plan)
//    {
//        ProductionPlanDTO productionPlanDTO = new ProductionPlanDTO();
//        AttemptDTO attemptDTO = buildAttemptDTO(plan);
//        productionPlanDTO.setAttempt(attemptDTO);
//        return productionPlanDTO;
//    }

//    private AttemptDTO buildAttemptDTO(final Plan plan)
//    {
//        AttemptDTO attemptDTO = new AttemptDTO();
//        Optional<Attempt> attemptOpt = attemptRepository.findById(plan.getId());
//        if (attemptOpt.isPresent())
//        {
//            Attempt attempt = attemptOpt.get();
//            String attemptTypeName = null;
//            if (attempt.getAttemptType() != null)
//            {
//                attemptTypeName = attempt.getAttemptType().getName();
//                attemptDTO.setAttemptType(attemptTypeName);
//            }
//            if (CRISPR_MUTAGENESIS_TYPE_NAME.equals(attemptTypeName))
//            {
//                CrisprAttemptDTO crisprAttemptDTO =
//                    crisprAttemptDTOBuilder.convertToDto(plan.getCrisprAttempt());
//                attemptDTO.setCrisprAttempt(crisprAttemptDTO);
//            }
//        }
//        return attemptDTO;
//    }
}
