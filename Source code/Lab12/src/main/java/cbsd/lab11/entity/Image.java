package cbsd.lab11.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: chillyprig
 * Date: 2/24/13
 * Time: 11:27 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Image {
    @Id
    @GeneratedValue
    private Long id;

    String filename;
    @Lob
    byte[] content;

    String contentType;

    Date created;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
