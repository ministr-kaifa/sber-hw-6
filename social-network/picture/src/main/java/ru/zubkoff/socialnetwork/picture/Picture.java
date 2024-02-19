package ru.zubkoff.socialnetwork.picture;

import java.net.URI;
import java.util.Objects;

public class Picture {
  private URI url;

  public Picture(URI url) {
    this.url = url;
  }

  public URI getUrl() {
    return url;
  }
  
  public void setUrl(URI url) {
    this.url = url;
  }

  @Override
  public int hashCode() {
    return Objects.hash(url);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Picture other = (Picture) obj;
    if (url == null) {
      return other.url == null;
    }
    return url.equals(other.url);
  }
}
