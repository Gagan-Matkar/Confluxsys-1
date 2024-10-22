package com.example.rbac.dao.impl;

import com.example.rbac.dao.RoleDAO;
import com.example.rbac.model.Role;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RoleDAOImpl implements RoleDAO {

    private final JdbcTemplate jdbcTemplate;

    public RoleDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createRole(Role role) {
        String sql = "INSERT INTO roles (role_name, description) VALUES (?, ?)";
        jdbcTemplate.update(sql, role.getRoleName(), role.getDescription());
        System.out.println("Role created: " + role.getRoleName());
    }

    @Override
    public Role getRoleById(int roleId) {
        String sql = "SELECT * FROM roles WHERE role_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{roleId}, new RoleRowMapper());
    }

    @Override
    public List<Role> getAllRoles() {
        String sql = "SELECT * FROM roles";
        return jdbcTemplate.query(sql, new RoleRowMapper());
    }

    @Override
    public void updateRole(Role role) {
        String sql = "UPDATE roles SET role_name = ?, description = ? WHERE role_id = ?";
        jdbcTemplate.update(sql, role.getRoleName(), role.getDescription(), role.getRoleId());
    }

    @Override
    public void deleteRole(int roleId) {
        String sql = "DELETE FROM roles WHERE role_id = ?";
        jdbcTemplate.update(sql, roleId);
    }

    private static class RoleRowMapper implements RowMapper<Role> {
        @Override
        public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
            Role role = new Role();
            role.setRoleId(rs.getInt("role_id"));
            role.setRoleName(rs.getString("role_name"));
            role.setDescription(rs.getString("description"));
            return role;
        }
    }
}
