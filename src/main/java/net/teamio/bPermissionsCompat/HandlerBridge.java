package net.teamio.bPermissionsCompat;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.nijiko.permissions.PermissionHandler;

import de.bananaco.bpermissions.api.ApiLayer;
import de.bananaco.bpermissions.api.WorldManager;
import de.bananaco.bpermissions.api.util.CalculableType;
import de.bananaco.bpermissions.api.util.Permission;

public class HandlerBridge extends PermissionHandler {

	public HandlerBridge(){
		if (Bukkit.getPluginManager().getPlugin("bPermissions") == null){
			throw new RuntimeException("bPermissions NOT found!");
		}
	}

	@Override
	public void setDefaultWorld(String world) {
		
	}

	@Override
	public boolean loadWorld(String world) {
		return true;
	}

	@Override
	public void forceLoadWorld(String world) {
		
	}

	@Override
	public boolean checkWorld(String world) {
		return WorldManager.getInstance().getWorld(world) != null;
	}

	@Override
	public void load() {
		
	}

	@Override
	public void reload() {
		
	}

	@Override
	public boolean reload(String world) {
		return true;
	}

	@Override
	public void setCache(String world, Map<String, Boolean> Cache) {
		
	}

	@Override
	public void setCacheItem(String world, String player, String permission,
			boolean data) {

	}

	@Override
	public Map<String, Boolean> getCache(String world) {
		return new HashMap<String,Boolean>();
	}

	@Override
	public boolean getCacheItem(String world, String player, String permission) {
		return true;
	}

	@Override
	public void removeCachedItem(String world, String player, String permission) {
		
	}

	@Override
	public void clearCache(String world) {
		
	}

	@Override
	public void clearAllCache() {
		
	}

	@Override
	public boolean has(Player player, String permission) {
		return ApiLayer.hasPermission(player.getWorld().getName(), CalculableType.USER, player.getName(), permission);
	}

	@Override
	public boolean has(String worldName, String playerName, String permission) {
		return ApiLayer.hasPermission(worldName, CalculableType.USER, playerName, permission);
	}

	@Override
	public boolean permission(Player player, String permission) {
		return has(player,permission);
	}

	@Override
	public boolean permission(String worldName, String playerName,
			String permission) {
		return has(worldName,playerName,permission);
	}

	@Override
	public String getGroup(String world, String name) {
		String[] groups = ApiLayer.getGroups(world, CalculableType.USER, name);
		return groups.length == 0 ? "" : groups == null ? " ": groups[groups.length - 1];
	}

	@Override
	public String[] getGroups(String world, String name) {
		return ApiLayer.getGroups(world, CalculableType.USER, name);
	}

	@Override
	public boolean inGroup(String world, String name, String group) {
		return ApiLayer.hasGroupRecursive(world, CalculableType.USER, name, group);
	}

	@Override
	public boolean inGroup(String name, String group) {
		return inGroup(Bukkit.getPlayer(name).getWorld().getName(),name,group);
	}

	@Override
	public boolean inSingleGroup(String world, String name, String group) {
		return ApiLayer.hasGroup(world, CalculableType.USER, name, group);
	}

	@Override
	public String getGroupPrefix(String world, String group) {
		return ApiLayer.getValue(world, CalculableType.GROUP, group, "prefix");
	}

	@Override
	public String getGroupSuffix(String world, String group) {
		return ApiLayer.getValue(world, CalculableType.GROUP, group, "suffix");
	}

	@Override
	public boolean canGroupBuild(String world, String group) {
		return true;
	}

	@Override
	public String getGroupPermissionString(String world, String group,
			String permission) {
		return null;
	}

	@Override
	public int getGroupPermissionInteger(String world, String group,
			String permission) {
		return 0;
	}

	@Override
	public boolean getGroupPermissionBoolean(String world, String group,
			String permission) {
		return false;
	}

	@Override
	public double getGroupPermissionDouble(String world, String group,
			String permission) {
		return 0;
	}

	@Override
	public String getUserPermissionString(String world, String name,
			String permission) {
		return "";
	}

	@Override
	public int getUserPermissionInteger(String world, String name,
			String permission) {
		return 0;
	}

	@Override
	public boolean getUserPermissionBoolean(String world, String name,
			String permission) {
		return this.has(world, name, permission);
	}

	@Override
	public double getUserPermissionDouble(String world, String name,
			String permission) {
		return 0;
	}

	@Override
	public String getPermissionString(String world, String name,
			String permission) {
		return "";
	}

	@Override
	public int getPermissionInteger(String world, String name, String permission) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getPermissionBoolean(String world, String name,
			String permission) {
		return this.has(world, name, permission);
	}

	@Override
	public double getPermissionDouble(String world, String name,
			String permission) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addGroupInfo(String world, String group, String node,
			Object data) {
	}

	@Override
	public void removeGroupInfo(String world, String group, String node) {

	}

	@Override
	public void addUserPermission(String world, String user, String node) {
		ApiLayer.addPermission(world, CalculableType.USER, user, Permission.loadFromString(node));
	}

	@Override
	public void removeUserPermission(String world, String user, String node) {
		ApiLayer.removePermission(world, CalculableType.USER, user, node);
	}

	@Override
	public void save(String world) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveAll() {
		// TODO Auto-generated method stub

	}

}
