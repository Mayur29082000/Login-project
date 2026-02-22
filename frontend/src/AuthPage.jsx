
import './AuthForm.css';

import { useState } from 'react';

import PasswordLogin from './PasswordLogin.jsx';
import OtpLogin from './OtpLogin.jsx';
import Signup from './Signup.jsx';
import { Link } from 'react-router-dom';

  const AuthPage = () => {
  const [activeTab, setActiveTab] = useState('true');
  const [leftTab, setLeftTab] = useState('password');
  const [rightTab, setRightTab] = useState('signup');

  return (
    <div className="auth-wrapper">
      <div className="active-container">
        <div className="active-tabs">
          {/* LEFT CARD */}
          <button
            className={activeTab === 'true' ? 'active' : ''}
            onClick={() => {
              setActiveTab('true');
            }}
          >
            Login
          </button>
          <button
            className={activeTab === 'false' ? 'active' : ''}
            onClick={() => {
              setActiveTab('false');
            }}
          >
            Signup/Register
          </button>
        </div>
        <div className="auth-container">
          {activeTab == 'true' ? (
            <div className="card">
              <div className="tabs">
                <button
                  className={leftTab === 'password' ? 'active' : ''}
                  onClick={() => {
                    setLeftTab('password');
                  }}
                >
                  Password Login
                </button>

                <button
                  className={leftTab === 'otp' ? 'active' : ''}
                  onClick={() => setLeftTab('otp')}
                >
                  OTP Login
                </button>
              </div>

              {leftTab === 'password' && <PasswordLogin />}
              {leftTab === 'otp' && <OtpLogin />}
            </div>
          ) : (
            <div className="card">
              <div className="tabs">
                <button
                  className={rightTab === 'signup' ? 'active' : ''}
                  onClick={() => {
                    setRightTab('signup');
                  }}
                >
                  Signup
                </button>
              </div>

              {rightTab === 'signup' && <Signup />}
            </div>
          )}


          
          
        </div>
        <div style={{ marginTop: "10px", textAlign: "center", color : "#bb541dff" }}>
        <Link to="/forgot-username">Forgot Username?</Link>
            {" | "}
            <Link to="/forgot-password">Forgot Password?</Link>
            </div>
      </div>
    </div>
  );
};
export default AuthPage;