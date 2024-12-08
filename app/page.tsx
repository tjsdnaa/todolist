"use client";

import React, { useState } from 'react';
import Login from './login';
import Todolist from './todolist';
import SignUp from './signup';
import axios from 'axios';


export default function Home() {
  const [user, setUser] = useState(null);
  const [join, setJoin] = useState(false);
  
  setUser(axios.get("http://localhost:9090/login").data);

  if (join) {
    return <SignUp setJoin={setJoin} />;
  }

  if (user === null) {
    return <Login  setUser={setUser}  setJoin={setJoin} />;
  } else {
    return <Todolist user={user} />;
  }
}