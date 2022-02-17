import { useParams } from "react-router-dom";
import React from "react";

export default function Addetails({data})
 {
  
  const {id} = useParams();
  const a= data.find((a) => a.id == id);

  return (
      <><h1>Action Details</h1><div>
      <div class="center">
    <div class="title"><p>ID-{a.id}</p></div>
    <div class="sub_title"><p>Name-{a.name}</p></div>
    </div>
    </div><button onClick={() => { window.location.href = "/admin/login"; } }>Back to Actions List</button>
    </>
  );
}
