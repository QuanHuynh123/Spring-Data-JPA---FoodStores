package com.example.food.mapper;
import com.example.food.dto.ProductDTO;
import com.example.food.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    //Các thuộc tính trùng tên thì không cần phải map
    @Mappings({// Ánh xạ id
            @Mapping(source = "productName", target = "productName"),
            @Mapping(source = "unitPrice", target = "unitPrice"),
            @Mapping(source = "packageType", target = "packageType"),
            @Mapping(source = "isDiscontinued", target = "isDiscontinued"),
            @Mapping(source = "supplier.id", target = "supplierId")
    })
    ProductDTO toDTO(ProductEntity productEntity);

    @Mappings({
            @Mapping(source = "productName", target = "productName"),
            @Mapping(source = "unitPrice", target = "unitPrice"),
            @Mapping(source = "packageType", target = "packageType"),
            @Mapping(source = "isDiscontinued", target = "isDiscontinued"),
            @Mapping(source = "supplierId", target = "supplier.id")
    })
    ProductEntity toEntity(ProductDTO productDTO);
}
