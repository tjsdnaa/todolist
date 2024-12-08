import React, { useState } from 'react';
import axios from 'axios';

function SignUp({ setJoin }) {
  const [userId, setUserId] = useState('');
  const [password, setPassword] = useState('');
  const [name, setName] = useState('');

  const handleSignUp = async (e) => {
    e.preventDefault(); // 폼 제출 기본 동작 방지

    // 서버에 회원가입 요청 보내기
    try {
      const response = await axios.post('http://localhost:9090/join', {
        userId,
        password,
        name,
      });

      // 서버 응답에 따라 처리
      if (response.data) {
        alert('회원가입 성공!');
        setJoin(false);
        // 회원가입 후 처리 (예: 로그인 페이지로 이동)
      }else{
        alert('회원가입 실패. 다시 시도해주세요.');
      }
    } catch (error) {
      console.error('회원가입 오류:', error);
      alert('회원가입 실패. 다시 시도해주세요.');
    }
  };

  return (
    <div>
      <h1>회원가입</h1>
      <form onSubmit={handleSignUp}>
        <input
          type="text"
          placeholder="아이디"
          value={userId}
          onChange={(e) => setUserId(e.target.value)}
        />
        <input
          type="password"
          placeholder="비밀번호"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
        <input
          type="text"
          placeholder="이름"
          value={name}
          onChange={(e) => setName(e.target.value)}
        />
        <button type="submit">회원가입</button>
      </form>
    </div>
  );
}

export default SignUp;