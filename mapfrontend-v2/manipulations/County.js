// @flow
// author: irfan-ahmed Fri, 09/22/2017

class County {
  constructor(props) {
    this.data = props;
  }
  
  getProperty(name) {
    return this.data.properties[name];
  }
  
  getProperties() {
    return this.data.properties;
  }
  
  getId() {
    return this.data.id;
  }
  
  setProperty(name, value) {
    if(!name) {
      return;
    }
    this.data.properties[name] = value;
  }
  
  getCounty() {
    return this.data;
  }
}

module.exports = County;
 
