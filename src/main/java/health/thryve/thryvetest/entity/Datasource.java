package health.thryve.thryvetest.entity;

import java.util.List;

public class Datasource {
	
	private Long id;
	private Long dataSource;
	private List<Data> data;
	
	public Datasource() {}
	
	public Datasource(Long dataSource, List<Data> data) {
		this.dataSource = dataSource;
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDataSource() {
		return dataSource;
	}

	public void setDataSource(Long dataSource) {
		this.dataSource = dataSource;
	}

	public List<Data> getData() {
		return data;
	}

	public void setData(List<Data> data) {
		this.data = data;
	}
}
