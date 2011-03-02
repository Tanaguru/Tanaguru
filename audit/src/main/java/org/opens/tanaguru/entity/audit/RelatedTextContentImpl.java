package org.opens.tanaguru.entity.audit;

import java.io.Serializable;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public abstract class RelatedTextContentImpl extends RelatedContentImpl implements
        TextContent, RelatedContent, Serializable {

    @Column(name = "Source", length = 400000)
    protected String source = null;

    @Column(name = "Adapted_Content", length = 400000)
    protected String adaptedContent = null;

    public RelatedTextContentImpl() {
        super();
    }

    public RelatedTextContentImpl(String uri,SSP ssp) {
        super(uri, ssp);
    }

    public RelatedTextContentImpl(Date dateOfLoading, String uri) {
        super(dateOfLoading, uri);
    }

    public RelatedTextContentImpl(Date dateOfLoading, String uri, SSP ssp) {
        super(dateOfLoading, uri, ssp);
    }

    public RelatedTextContentImpl(Date dateOfLoading, String uri, SSP ssp, String source) {
        super(dateOfLoading, uri, ssp);
        this.source = source;
    }

    public RelatedTextContentImpl(Date dateOfLoading, String uri, SSP ssp, String source, int httpStatusCode) {
        super(dateOfLoading, uri, ssp, httpStatusCode);
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAdaptedContent() {
        return adaptedContent;
    }

    public void setAdaptedContent(String adaptedContent) {
        this.adaptedContent = adaptedContent;
    }

}
