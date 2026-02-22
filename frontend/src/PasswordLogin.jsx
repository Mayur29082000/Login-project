import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

const PasswordLogin = () => {
  const navigate = useNavigate();

  const [form, setForm] = useState({
    username: "",
    password: "",
  });

  const handlePasswordLogin = async (e) => {
    e.preventDefault();

    try {
      const response = await fetch(
        "http://localhost:8089/users/login/loginByPass",
        {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(form),
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
    <form className="form" onSubmit={handlePasswordLogin}>
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
        placeholder="Password"
        value={form.password}
        onChange={(e) =>
          setForm({ ...form, password: e.target.value })
        }
      />

      <button type="submit" className="primary-btn">
        Login
      </button>
    </form>
  );
};

export default PasswordLogin;