import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

const OtpLogin = () => {
  const navigate = useNavigate();

  const [mobile, setMobile] = useState("");
  const [otp, setOtp] = useState("");

    const [showPopup, setShowPopup] = useState(false);
  const [generatedOtp, setGeneratedOtp] = useState("");

  const sendOtp = async (e) => {
    e.preventDefault();

    if (!mobile) {
      alert("Please enter mobile number");
      return;
    }

    try {
      const response = await fetch(
        "http://localhost:8089/users/send-otp",
        {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify({ mobileNo: mobile }),
        }
      );

      const data = await response.json();

      if (!response.ok) {
        throw new Error(data.message || "OTP send failed");
      }

      

       // ✅ Show OTP in popup
      setGeneratedOtp(data.otp);
      setShowPopup(true);
      // ✅ show OTP in alert
      alert("Your OTP is: " + data.otp);

    } catch (error) {
      alert(error.message);
    }
  };

  const verifyOtpLogin = async (e) => {
    e.preventDefault();

    if (!mobile || !otp) {
      alert("Please enter mobile and OTP");
      return;
    }

    try {
      const response = await fetch(
        "http://localhost:8089/users/verify-otp",
        {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify({ mobileNo: mobile, otp }),
        }
      );

      const data = await response.json();

      if (!response.ok) {
        throw new Error(data.message || "Login failed");
      }

      localStorage.setItem("token", data.token);

      navigate("/welcome"); // ✅ redirect
    } catch (error) {
      alert(error.message);
    }
  };

  return (
    <form className="form">
      <input
        type="text"
        placeholder="Mobile Number"
        value={mobile}
        onChange={(e) => setMobile(e.target.value)}
      />

      <button
        type="button"
        className="secondary-btn"
        onClick={sendOtp}
      >
        Send OTP
      </button>

      <input
        type="text"
        placeholder="Enter OTP"
        value={otp}
        onChange={(e) => setOtp(e.target.value)}
      />

      <button
        type="button"
        className="primary-btn"
        onClick={verifyOtpLogin}
      >
        Verify & Login
      </button>
    </form>
  );
};

export default OtpLogin;