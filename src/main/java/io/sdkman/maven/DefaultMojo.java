package io.sdkman.maven;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpPut;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.net.URI;
import java.util.Map;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
@Mojo(name = "default")
public class DefaultMojo extends BaseMojo {

  @Parameter(property = "sdkman.default", required = true)
  protected String _default;

  public String getDefault() {
    return _default;
  }

  public void setDefault(String _default) {
    this._default = _default;
  }

  @Override
  protected Map<String, String> getPayload() throws Exception {
    Map<String, String> payload = super.getPayload();
    payload.put("default", _default);
    return payload;
  }

  @Override
  protected HttpEntityEnclosingRequestBase createHttpRequest() throws Exception {
    return new HttpPut(new URI("https", apiHost, "/default", null));
  }
}
