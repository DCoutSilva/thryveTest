package health.thryve.thryvetest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="data")
public class Data {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private Long startTimestampUnix;
	@Column
	private Long endTimestampUnix;
	@Column
	private Long createdAtUnix;
	@Column
	private Long dynamicValueType;
	@Column
	private Long value;
	@Column
	private String valueType;
	@Column
	private Long dataSource;
	@Column
	private Long userId;
	
	public Data() {}
	
	public Data(Long startTimestampUnix, Long endTimestampUnix, Long createdAtUnix, Long dynamicValueType,
			Long value, String valueType, Long dataSource, Long userId) {
		
		this.startTimestampUnix = startTimestampUnix;
		this.endTimestampUnix = endTimestampUnix;
		this.createdAtUnix = createdAtUnix;
		this.dynamicValueType = dynamicValueType;
		this.value = value;
		this.valueType = valueType;
		this.dataSource= dataSource;
		this.userId = userId;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getStartTimestampUnix() {
		return startTimestampUnix;
	}
	public void setStartTimestampUnix(Long startTimestampUnix) {
		this.startTimestampUnix = startTimestampUnix;
	}
	public Long getEndTimestampUnix() {
		return endTimestampUnix;
	}
	public void setEndTimestampUnix(Long endTimestampUnix) {
		this.endTimestampUnix = endTimestampUnix;
	}
	public Long getCreatedAtUnix() {
		return createdAtUnix;
	}
	public void setCreatedAtUnix(Long createdAtUnix) {
		this.createdAtUnix = createdAtUnix;
	}
	public Long getDynamicValueType() {
		return dynamicValueType;
	}
	public void setDynamicValueType(Long dynamicValueType) {
		this.dynamicValueType = dynamicValueType;
	}
	public Long getValue() {
		return value;
	}
	public void setValue(Long value) {
		this.value = value;
	}
	public String getValueType() {
		return valueType;
	}
	public void setValueType(String valueType) {
		this.valueType = valueType;
	}

	public Long getDataSource() {
		return dataSource;
	}

	public void setDataSource(Long dataSource) {
		this.dataSource = dataSource;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
