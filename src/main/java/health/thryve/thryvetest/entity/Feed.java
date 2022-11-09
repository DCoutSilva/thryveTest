package health.thryve.thryvetest.entity;

import java.util.List;

public class Feed {

	private Long userId;
	private Long authenticationToken;
	private List<Datasource> dataSources;
	
	public Feed() {}
	
	public Feed(Long authenticationToken, List<Datasource> datasources) {
		this.authenticationToken = authenticationToken;
		this.dataSources = datasources;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long id) {
		this.userId = id;
	}

	public Long getAuthenticationToken() {
		return authenticationToken;
	}

	public void setAuthenticationToken(Long authenticationToken) {
		this.authenticationToken = authenticationToken;
	}

	public List<Datasource> getDataSources() {
		return dataSources;
	}

	public void setDataSources(List<Datasource> dataSources) {
		this.dataSources = dataSources;
	}
	
}
