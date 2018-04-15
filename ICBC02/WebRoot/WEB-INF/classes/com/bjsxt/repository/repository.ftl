package ${basePackage}.${repository.package};

import org.springframework.stereotype.Repository;
import java.util.*;
import ${basePackage}.${model.package}.*;

public interface ${repository.class}{
	public void insert(${model.class} entity);
	public void update(${model.class} entity);
	public void delete(${model.id.type} ${model.id.name});
	public Map findById(${model.id.type} ${model.id.name});
	public List<Map> findByProperty(Map params);
}
