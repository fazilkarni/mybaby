package com.koolfrenz;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class JavaCollection {
	public List names;
	public Set animalSet;
	public Map nameAddressMap;
	public Properties props;
	
	public List getNames() {
		
		System.out.println("Names :"+names);
		return names;
	}
	public void setNames(List names) {
		this.names = names;
	}
	public Set getAnimalSet() {
		System.out.println("animals :"+animalSet);
		return animalSet;
	}
	public void setAnimalSet(Set animalSet) {
		this.animalSet = animalSet;
	}
	public Map getNameAddressMap() {
		System.out.println("Name address map :"+nameAddressMap);
		return nameAddressMap;
	}
	public void setNameAddressMap(Map nameAddressMap) {
		this.nameAddressMap = nameAddressMap;
	}
	public Properties getProps() {
		System.out.println("props :"+props);
		return props;
	}
	public void setProps(Properties props) {
		this.props = props;
	}
	
	

}
