package com.smartcleaner.pro.data.local;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class PhoneCleanerDatabase_Impl extends PhoneCleanerDatabase {
  private volatile CleaningHistoryDao _cleaningHistoryDao;

  private volatile WhitelistedAppDao _whitelistedAppDao;

  private volatile UserPreferenceDao _userPreferenceDao;

  private volatile AdImpressionDao _adImpressionDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `cleaning_history` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `timestamp` INTEGER NOT NULL, `cleanedSize` INTEGER NOT NULL, `cleanedItems` INTEGER NOT NULL, `duration` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `whitelisted_apps` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `packageName` TEXT NOT NULL, `appName` TEXT NOT NULL, `isWhitelisted` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `user_preferences` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `key` TEXT NOT NULL, `value` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `ad_impressions` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `adId` TEXT NOT NULL, `timestamp` INTEGER NOT NULL, `impressionType` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'abaf7ab52624e8ccdc80e4be54d374bc')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `cleaning_history`");
        db.execSQL("DROP TABLE IF EXISTS `whitelisted_apps`");
        db.execSQL("DROP TABLE IF EXISTS `user_preferences`");
        db.execSQL("DROP TABLE IF EXISTS `ad_impressions`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsCleaningHistory = new HashMap<String, TableInfo.Column>(5);
        _columnsCleaningHistory.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCleaningHistory.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCleaningHistory.put("cleanedSize", new TableInfo.Column("cleanedSize", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCleaningHistory.put("cleanedItems", new TableInfo.Column("cleanedItems", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCleaningHistory.put("duration", new TableInfo.Column("duration", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCleaningHistory = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCleaningHistory = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCleaningHistory = new TableInfo("cleaning_history", _columnsCleaningHistory, _foreignKeysCleaningHistory, _indicesCleaningHistory);
        final TableInfo _existingCleaningHistory = TableInfo.read(db, "cleaning_history");
        if (!_infoCleaningHistory.equals(_existingCleaningHistory)) {
          return new RoomOpenHelper.ValidationResult(false, "cleaning_history(com.smartcleaner.pro.data.local.CleaningHistory).\n"
                  + " Expected:\n" + _infoCleaningHistory + "\n"
                  + " Found:\n" + _existingCleaningHistory);
        }
        final HashMap<String, TableInfo.Column> _columnsWhitelistedApps = new HashMap<String, TableInfo.Column>(4);
        _columnsWhitelistedApps.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWhitelistedApps.put("packageName", new TableInfo.Column("packageName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWhitelistedApps.put("appName", new TableInfo.Column("appName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWhitelistedApps.put("isWhitelisted", new TableInfo.Column("isWhitelisted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysWhitelistedApps = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesWhitelistedApps = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoWhitelistedApps = new TableInfo("whitelisted_apps", _columnsWhitelistedApps, _foreignKeysWhitelistedApps, _indicesWhitelistedApps);
        final TableInfo _existingWhitelistedApps = TableInfo.read(db, "whitelisted_apps");
        if (!_infoWhitelistedApps.equals(_existingWhitelistedApps)) {
          return new RoomOpenHelper.ValidationResult(false, "whitelisted_apps(com.smartcleaner.pro.data.local.WhitelistedApp).\n"
                  + " Expected:\n" + _infoWhitelistedApps + "\n"
                  + " Found:\n" + _existingWhitelistedApps);
        }
        final HashMap<String, TableInfo.Column> _columnsUserPreferences = new HashMap<String, TableInfo.Column>(3);
        _columnsUserPreferences.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserPreferences.put("key", new TableInfo.Column("key", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserPreferences.put("value", new TableInfo.Column("value", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUserPreferences = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUserPreferences = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUserPreferences = new TableInfo("user_preferences", _columnsUserPreferences, _foreignKeysUserPreferences, _indicesUserPreferences);
        final TableInfo _existingUserPreferences = TableInfo.read(db, "user_preferences");
        if (!_infoUserPreferences.equals(_existingUserPreferences)) {
          return new RoomOpenHelper.ValidationResult(false, "user_preferences(com.smartcleaner.pro.data.local.UserPreference).\n"
                  + " Expected:\n" + _infoUserPreferences + "\n"
                  + " Found:\n" + _existingUserPreferences);
        }
        final HashMap<String, TableInfo.Column> _columnsAdImpressions = new HashMap<String, TableInfo.Column>(4);
        _columnsAdImpressions.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAdImpressions.put("adId", new TableInfo.Column("adId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAdImpressions.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAdImpressions.put("impressionType", new TableInfo.Column("impressionType", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAdImpressions = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAdImpressions = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAdImpressions = new TableInfo("ad_impressions", _columnsAdImpressions, _foreignKeysAdImpressions, _indicesAdImpressions);
        final TableInfo _existingAdImpressions = TableInfo.read(db, "ad_impressions");
        if (!_infoAdImpressions.equals(_existingAdImpressions)) {
          return new RoomOpenHelper.ValidationResult(false, "ad_impressions(com.smartcleaner.pro.data.local.AdImpression).\n"
                  + " Expected:\n" + _infoAdImpressions + "\n"
                  + " Found:\n" + _existingAdImpressions);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "abaf7ab52624e8ccdc80e4be54d374bc", "523bc7b8dea017b92eb8ceb9537c6598");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "cleaning_history","whitelisted_apps","user_preferences","ad_impressions");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `cleaning_history`");
      _db.execSQL("DELETE FROM `whitelisted_apps`");
      _db.execSQL("DELETE FROM `user_preferences`");
      _db.execSQL("DELETE FROM `ad_impressions`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(CleaningHistoryDao.class, CleaningHistoryDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(WhitelistedAppDao.class, WhitelistedAppDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(UserPreferenceDao.class, UserPreferenceDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(AdImpressionDao.class, AdImpressionDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public CleaningHistoryDao cleaningHistoryDao() {
    if (_cleaningHistoryDao != null) {
      return _cleaningHistoryDao;
    } else {
      synchronized(this) {
        if(_cleaningHistoryDao == null) {
          _cleaningHistoryDao = new CleaningHistoryDao_Impl(this);
        }
        return _cleaningHistoryDao;
      }
    }
  }

  @Override
  public WhitelistedAppDao whitelistedAppDao() {
    if (_whitelistedAppDao != null) {
      return _whitelistedAppDao;
    } else {
      synchronized(this) {
        if(_whitelistedAppDao == null) {
          _whitelistedAppDao = new WhitelistedAppDao_Impl(this);
        }
        return _whitelistedAppDao;
      }
    }
  }

  @Override
  public UserPreferenceDao userPreferenceDao() {
    if (_userPreferenceDao != null) {
      return _userPreferenceDao;
    } else {
      synchronized(this) {
        if(_userPreferenceDao == null) {
          _userPreferenceDao = new UserPreferenceDao_Impl(this);
        }
        return _userPreferenceDao;
      }
    }
  }

  @Override
  public AdImpressionDao adImpressionDao() {
    if (_adImpressionDao != null) {
      return _adImpressionDao;
    } else {
      synchronized(this) {
        if(_adImpressionDao == null) {
          _adImpressionDao = new AdImpressionDao_Impl(this);
        }
        return _adImpressionDao;
      }
    }
  }
}
