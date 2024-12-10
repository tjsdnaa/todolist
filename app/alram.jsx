import { useEffect, useState } from 'react';

function Alram({ todolist }) {
  const [selectedDate, setSelectedDate] = useState(new Date().toISOString().slice(0, 16));
  const [notifiedTodos, setNotifiedTodos] = useState([]); // 이미 알람을 보낸 항목 추적

  useEffect(() => {
    const timer = setInterval(() => {
      setSelectedDate(new Date(new Date().getTime() + 9 * 60 * 60 * 1000).toISOString().slice(0, 16));
    }, 1000);
    return () => clearInterval(timer);
  }, [selectedDate]);

  useEffect(() => {
    const checkAlarm = () => {
      todolist.forEach((todo) => {
        const closingDate = new Date(todo.closingDate); // 마감 날짜
        const currentDate = new Date(selectedDate); // 문자열을 Date 객체로 변환
  
        // 5분 차이 계산
        const timeDifference = Math.abs(currentDate - closingDate);
        const fiveMinutesInMillis = 5 * 60 * 1000; // 5분을 밀리초로 변환
  
        console.log(timeDifference);
        // 이미 알림을 보냈는지 확인
        if (timeDifference <= fiveMinutesInMillis && !notifiedTodos.includes(todo.id)) {
          alert(`할일 "${todo.title}"가 5분 전입니다.`);
          setNotifiedTodos((prev) => [...prev, todo.id]); // 알림 보낸 항목 추가
        }
      });
    };
  
    checkAlarm();
  }, [selectedDate, todolist, notifiedTodos]);

  return (
    <div>
      {/* 필요한 UI 구성 */}
    </div>
  );
}

export default Alram;
