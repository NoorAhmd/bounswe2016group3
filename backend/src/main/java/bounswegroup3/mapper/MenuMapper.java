package bounswegroup3.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import bounswegroup3.model.Menu;

public class MenuMapper implements ResultSetMapper<Menu> {
	@Override
	public Menu map(int row, ResultSet rs, StatementContext ctx) throws SQLException {
		final Long id = rs.getLong("id");
		final Long userId = rs.getLong("user_id");
		final String name = rs.getString("name");

		return new Menu(id, userId, name);
	}
}
