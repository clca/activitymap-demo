// author: irfan-ahmed Fri, 09/22/2017

import React from "react";
import "./property.css"

const Property = (props) => {
  const { label, value, extra, children } = props;
  return <div className="property">
    <label className="label">{label}</label>
    <div className="valueContainer">
      <div className="value">{value || children}</div>
      {extra && <div className="extra">{extra}</div>}
    </div>
  </div>
};

Property.displayName = "Property";

export default Property;
