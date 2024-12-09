"use client";

import { useState, useEffect } from 'react';
import Login from './login';
import Todolist from './todolist';
import SignUp from './signup';
import axios from 'axios';
import './App.css'; // 위에서 작성한 CSS를 임포트합니다.

export default function Home() {
  const [user, setUser] = useState(null);
  const [join, setJoin] = useState(false);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    axios.get("http://localhost:9090/login")
      .then(response => {
        console.log('Full response:', response); 
        console.log('Response data:', response.data);
        setUser(response.data);
        setLoading(false);
      })
      .catch(error => {
        console.error('Error fetching login data:', error);
      });
  }, []);
  
  if(loading) {
    return (
      <div className="container">
        <div className="loading">로딩중...</div>
      </div>
    );
  }

  if (join) {
    return <SignUp setJoin={setJoin} />;
  }

  if (user === null || user === "") {
    return <Login setUser={setUser} setJoin={setJoin} />;
  } else {
    return (
      <div className="container">
        <Todolist user={user} />
      </div>
    );
  }
}
