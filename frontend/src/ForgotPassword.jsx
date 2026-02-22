import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

const ForgotPassword = () => {
  const navigate = useNavigate();

  const [form, setForm] = useState({
    username: "",
    newPassword: "",
    confirmPassword: ""
  });

  const handlePasswordReset = async (e) => {
    e.preventDefault();

    if (!form.username || !form.newPassword || !form.confirmPassword) {
      alert("All fields are required");
      return;
    }

    if (form.newPassword !== form.confirmPassword) {
      alert("New password and confirm password do not match");
      return;
    }

    try {
      const response = await fetch(
        "http://localhost:8089/users/reset-password",
        {
          method: "PUT",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(form),
        }
      );

      if (!response.ok) {
        const errorText = await response.text();
        throw new Error(errorText);
      }

      const data = await response.text();
      alert(data);

      navigate("/");

    } catch (error) {
      alert(error.message);
    }
  };

  return (
    <div className="auth-wrapper">
        <div className="active-container">
            
            <h2 style={{ textAlign: "center", marginBottom: "20px", color : "black" }}>Forgot Password</h2>
    <form className="form" onSubmit={handlePasswordReset}>
      <input
        type="text"
        placeholder="Username"
        value={form.username}
        onChange={(e) =>
          setForm({ ...form, username: e.target.value })
        }
      />

      <input
        type="password"
        placeholder="New Password"
        value={form.newPassword}
        onChange={(e) =>
          setForm({ ...form, newPassword: e.target.value })
        }
      />

      <input
        type="password"
        placeholder="Confirm New Password"
        value={form.confirmPassword}
        onChange={(e) =>
          setForm({ ...form, confirmPassword: e.target.value })
        }
      />

      <button type="submit" className="primary-btn">
        Reset Password
      </button>
    </form>
    </div>
    </div>
   
  );
};

export default ForgotPassword;