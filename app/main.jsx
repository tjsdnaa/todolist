import Login from './login';
import Todolist from './todolist';
import axios from "axios";

async function Main() {
  let content;
  
  const response = await axios.get("http://localhost:9090/login");
  
  let islogined=response.data;

  if(!islogined){
    content =<Login/>;
  } else{
    content = <Todolist/>;
  }
  return content;
}

export default Main;