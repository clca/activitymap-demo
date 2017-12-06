// author: irfan-ahmed Fri, 09/22/2017

import React from "react";
import "./tile.css";

const Tile = (props) => {
  const { label, value } = props;
  return <div className="tileContainer">
    <div className={"label"}>{label}</div>
    <div className={"value"}>{value}</div>
  </div>
}

Tile.displayName = "Tile";

export default Tile;
