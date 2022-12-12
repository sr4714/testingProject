import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { Link } from "react-router-dom";
import UserService from '../services/UserService';



function Login() {
  const navigate = useNavigate();

  const [username, setUserName] = useState();
  const [password, setPassword] = useState();

  const getUsers = (e) => {
    e.preventDefault();
    let user = { username: username, password: password };
    console.log(user);
    UserService.getUser(username, password).then((Response) => {
      console.log("response: " + Response.data);
      if (Response.data !== '') {
        navigate('dashboard', {
          username: username
        });
      } else {
        alert("Invalid login info");
      }
    }).catch((error) => {
      console.log(error.response);
    });
  }

  return (
    <div className="login">
      <h1>Please Log In</h1>
      <Link className='btn btn-primary' to="/signUp">Signup</Link>
      <form onSubmit={getUsers}>
        <label>
          <p>Username</p>
          <input role="input box" placeholder="Enter Username" type="text" onChange={e => setUserName(e.target.value)} />
        </label>
        <label>
          <p>Password</p>
          <input placeholder="Enter Password" type="password" onChange={e => setPassword(e.target.value)} />
        </label>
        <div>
          <button role="submit" type="submit">Submit</button>
        </div>
      </form>
    </div>
  )
}

export default Login;