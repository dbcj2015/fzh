package ${basePackage}.${repository.package};

import org.springframework.stereotype.Repository;
import java.util.*;
import ${basePackage}.${model.package}.*;
@SuppressWarnings("all")
public interface ${repository.class}{
	public void insert(${model.class} entity);
	public void update(${model.class} entity);
	public void delete(${model.id.type} ${model.id.name});
	public ${model.class} findById(${model.id.type} ${model.id.name});
	public List<Map> findByProperty(Map params);
	public Long countByProperty(Map params);
}
