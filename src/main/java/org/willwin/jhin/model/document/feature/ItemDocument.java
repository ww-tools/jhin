package org.willwin.jhin.model.document.feature;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDocument
{

    @Field("item_id")
    private Integer itemId;

    @Field("purchase_order")
    private Integer purchaseOrder;

    @Field("purchase_time")
    private Long purchaseTime;

}
