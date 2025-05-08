package physic.ai.domain.products.dto;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import physic.ai.domain.products.ProductEntity;

@Mapper(componentModel = "cdi",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {
    ProductEntity toProductEntity(NewProductDto newProduct);
}