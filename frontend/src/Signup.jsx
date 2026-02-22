import React, { useState } from "react";

const Signup = () => {
  const [form, setForm] = useState({
    username: "",
    password: "",
    email: "",
    mobileNo: "",
  });

  const [message, setMessage] = useState("");

  const handleSignup = async (e) => {
    e.preventDefault();

    try {
      const response = await fetch(
        "http://localhost:8089/users/signup",
        {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(form),
        }
      );

      const data = await response.json();

      if (!response.ok) {
        throw new Error(data.message || "Signup failed");
      }

      // ✅ show green message
      setMessage("Signup successful!");
    } catch (error) {
      setMessage("");
      alert(error.message);
    }
  };

  return (
    <form className="form" onSubmit={handleSignup}>
      <input
        type="text"
        placeholder="Username"
        value={form.username}
        onChange={(e) =>
          setForm({ ...form, username: e.target.value })
        }
      />

      <input
        type="email"
        placeholder="Email"
        value={form.email}
        onChange={(e) =>
          setForm({ ...form, email: e.target.value })
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

      <input
        type="text"
        placeholder="Mobile"
        value={form.mobileNo}
        onChange={(e) =>
          setForm({ ...form, mobileNo: e.target.value })
        }
      />

      <button type="submit" className="primary-btn">
        Create Account
      </button>

      {message && (
        <p style={{ color: "green", marginTop: "10px" }}>
          {message}
        </p>
      )}
    </form>
  );
};

export default Signup;