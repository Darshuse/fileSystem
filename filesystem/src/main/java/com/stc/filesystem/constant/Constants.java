package com.stc.filesystem.constant;

public class Constants {

	public enum PermissionLevel {
		EDIT("edit"), VIEW("view");

		private PermissionLevel(String value) {
			this.value = value;
		}

		public final String value;

		public String getValue() {
			return value;
		}

	}

	public enum ItemType {
		SPACE(1), FOLDER(2), FILE(3);

		public final Integer value;

		private ItemType(Integer value) {
			this.value = value;
		}

		public Integer getValue() {
			return value;
		}

	}

}
