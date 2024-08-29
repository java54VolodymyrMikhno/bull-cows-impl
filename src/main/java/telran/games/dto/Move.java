package telran.games.dto;

import org.json.JSONObject;

public record Move(long gameId, String guess) {
	@Override
	public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("gameId", gameId);
		jsonObj.put("guess", guess);
		return jsonObj.toString();
	}
	public Move(JSONObject jsonObj) {
		this(jsonObj.getLong("gameId"), jsonObj.getString("guess"));
	}
}
