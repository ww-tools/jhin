package org.willwin.jhin.document;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;

/**
 * Base document class containing common audit fields for MongoDB documents.
 * All MongoDB document classes should extend this class to inherit audit functionality.
 */
@Data
public abstract class BaseDocument
{

    /**
     * The user who created this document.
     * Automatically populated by Spring Data MongoDB auditing.
     */
    @CreatedBy
    @Field("created_by")
    private String createdBy;

    /**
     * The timestamp when this document was created.
     * Automatically populated by Spring Data MongoDB.
     */
    @CreatedDate
    @Field("created_date")
    private Instant createdDate;

    /**
     * The user who last modified this document.
     * Automatically populated by Spring Data MongoDB auditing.
     */
    @LastModifiedBy
    @Field("last_modified_by")
    private String lastModifiedBy;

    /**
     * The timestamp when this document was last modified.
     * Automatically populated by Spring Data MongoDB.
     */
    @LastModifiedDate
    @Field("last_modified_date")
    private Instant lastModifiedDate;

}
