import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

const ForgotUsername = () => {
  const navigate = useNavigate();

  const [form, setForm] = useState({
    email: "",
    newUsername: "",
    confirmUsername: ""
  });

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (!form.email || !form.newUsername || !form.confirmUsername) {
      alert("All fields are required");
      return;
    }

    if (form.newUsername !== form.confirmUsername) {
      alert("Username does not match");
      return;
    }

    try {
      const response = await fetch(
        "http://localhost:8089/users/reset-username",
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
            
            <h2 style={{ textAlign: "center", marginBottom: "20px", color : "black" }}>Forgot Username</h2>
    <form className="form" onSubmit={handleSubmit}>
      <input
        type="email"
        placeholder="Registered Email"
        value={form.email}
        onChange={(e) =>
          setForm({ ...form, email: e.target.value })
        }
      />

      <input
        type="text"
        placeholder="New Username"
        value={form.newUsername}
        onChange={(e) =>
          setForm({ ...form, newUsername: e.target.value })
        }
      />

      <input
        type="text"
        placeholder="Confirm Username"
        value={form.confirmUsername}
        onChange={(e) =>
          setForm({ ...form, confirmUsername: e.target.value })
        }
      />

      <button type="submit" className="primary-btn">
        Reset Username
      </button>
    </form>
    </div>
     </div>
  );
};

export default ForgotUsername;