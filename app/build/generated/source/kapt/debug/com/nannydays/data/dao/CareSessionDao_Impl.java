package com.nannydays.data.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.nannydays.data.model.CareSession;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Float;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class CareSessionDao_Impl implements CareSessionDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<CareSession> __insertionAdapterOfCareSession;

  private final EntityDeletionOrUpdateAdapter<CareSession> __deletionAdapterOfCareSession;

  private final EntityDeletionOrUpdateAdapter<CareSession> __updateAdapterOfCareSession;

  private final SharedSQLiteStatement __preparedStmtOfDeleteSessionById;

  public CareSessionDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCareSession = new EntityInsertionAdapter<CareSession>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `care_sessions` (`id`,`childId`,`checkInTime`,`checkOutTime`,`notes`,`createdAt`,`updatedAt`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final CareSession entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getChildId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getChildId());
        }
        statement.bindLong(3, entity.getCheckInTime());
        if (entity.getCheckOutTime() == null) {
          statement.bindNull(4);
        } else {
          statement.bindLong(4, entity.getCheckOutTime());
        }
        if (entity.getNotes() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getNotes());
        }
        statement.bindLong(6, entity.getCreatedAt());
        statement.bindLong(7, entity.getUpdatedAt());
      }
    };
    this.__deletionAdapterOfCareSession = new EntityDeletionOrUpdateAdapter<CareSession>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `care_sessions` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final CareSession entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
      }
    };
    this.__updateAdapterOfCareSession = new EntityDeletionOrUpdateAdapter<CareSession>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `care_sessions` SET `id` = ?,`childId` = ?,`checkInTime` = ?,`checkOutTime` = ?,`notes` = ?,`createdAt` = ?,`updatedAt` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final CareSession entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getChildId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getChildId());
        }
        statement.bindLong(3, entity.getCheckInTime());
        if (entity.getCheckOutTime() == null) {
          statement.bindNull(4);
        } else {
          statement.bindLong(4, entity.getCheckOutTime());
        }
        if (entity.getNotes() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getNotes());
        }
        statement.bindLong(6, entity.getCreatedAt());
        statement.bindLong(7, entity.getUpdatedAt());
        if (entity.getId() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getId());
        }
      }
    };
    this.__preparedStmtOfDeleteSessionById = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM care_sessions WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertSession(final CareSession session,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfCareSession.insert(session);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteSession(final CareSession session,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfCareSession.handle(session);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateSession(final CareSession session,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfCareSession.handle(session);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteSessionById(final String sessionId,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteSessionById.acquire();
        int _argIndex = 1;
        if (sessionId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, sessionId);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteSessionById.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<CareSession>> getAllSessions() {
    final String _sql = "SELECT * FROM care_sessions ORDER BY checkInTime DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"care_sessions"}, new Callable<List<CareSession>>() {
      @Override
      @NonNull
      public List<CareSession> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfChildId = CursorUtil.getColumnIndexOrThrow(_cursor, "childId");
          final int _cursorIndexOfCheckInTime = CursorUtil.getColumnIndexOrThrow(_cursor, "checkInTime");
          final int _cursorIndexOfCheckOutTime = CursorUtil.getColumnIndexOrThrow(_cursor, "checkOutTime");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<CareSession> _result = new ArrayList<CareSession>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final CareSession _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpChildId;
            if (_cursor.isNull(_cursorIndexOfChildId)) {
              _tmpChildId = null;
            } else {
              _tmpChildId = _cursor.getString(_cursorIndexOfChildId);
            }
            final long _tmpCheckInTime;
            _tmpCheckInTime = _cursor.getLong(_cursorIndexOfCheckInTime);
            final Long _tmpCheckOutTime;
            if (_cursor.isNull(_cursorIndexOfCheckOutTime)) {
              _tmpCheckOutTime = null;
            } else {
              _tmpCheckOutTime = _cursor.getLong(_cursorIndexOfCheckOutTime);
            }
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _item = new CareSession(_tmpId,_tmpChildId,_tmpCheckInTime,_tmpCheckOutTime,_tmpNotes,_tmpCreatedAt,_tmpUpdatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<CareSession>> getSessionsByChildId(final String childId) {
    final String _sql = "SELECT * FROM care_sessions WHERE childId = ? ORDER BY checkInTime DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (childId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, childId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"care_sessions"}, new Callable<List<CareSession>>() {
      @Override
      @NonNull
      public List<CareSession> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfChildId = CursorUtil.getColumnIndexOrThrow(_cursor, "childId");
          final int _cursorIndexOfCheckInTime = CursorUtil.getColumnIndexOrThrow(_cursor, "checkInTime");
          final int _cursorIndexOfCheckOutTime = CursorUtil.getColumnIndexOrThrow(_cursor, "checkOutTime");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<CareSession> _result = new ArrayList<CareSession>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final CareSession _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpChildId;
            if (_cursor.isNull(_cursorIndexOfChildId)) {
              _tmpChildId = null;
            } else {
              _tmpChildId = _cursor.getString(_cursorIndexOfChildId);
            }
            final long _tmpCheckInTime;
            _tmpCheckInTime = _cursor.getLong(_cursorIndexOfCheckInTime);
            final Long _tmpCheckOutTime;
            if (_cursor.isNull(_cursorIndexOfCheckOutTime)) {
              _tmpCheckOutTime = null;
            } else {
              _tmpCheckOutTime = _cursor.getLong(_cursorIndexOfCheckOutTime);
            }
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _item = new CareSession(_tmpId,_tmpChildId,_tmpCheckInTime,_tmpCheckOutTime,_tmpNotes,_tmpCreatedAt,_tmpUpdatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<CareSession> getSessionById(final String sessionId) {
    final String _sql = "SELECT * FROM care_sessions WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (sessionId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, sessionId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"care_sessions"}, new Callable<CareSession>() {
      @Override
      @Nullable
      public CareSession call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfChildId = CursorUtil.getColumnIndexOrThrow(_cursor, "childId");
          final int _cursorIndexOfCheckInTime = CursorUtil.getColumnIndexOrThrow(_cursor, "checkInTime");
          final int _cursorIndexOfCheckOutTime = CursorUtil.getColumnIndexOrThrow(_cursor, "checkOutTime");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final CareSession _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpChildId;
            if (_cursor.isNull(_cursorIndexOfChildId)) {
              _tmpChildId = null;
            } else {
              _tmpChildId = _cursor.getString(_cursorIndexOfChildId);
            }
            final long _tmpCheckInTime;
            _tmpCheckInTime = _cursor.getLong(_cursorIndexOfCheckInTime);
            final Long _tmpCheckOutTime;
            if (_cursor.isNull(_cursorIndexOfCheckOutTime)) {
              _tmpCheckOutTime = null;
            } else {
              _tmpCheckOutTime = _cursor.getLong(_cursorIndexOfCheckOutTime);
            }
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _result = new CareSession(_tmpId,_tmpChildId,_tmpCheckInTime,_tmpCheckOutTime,_tmpNotes,_tmpCreatedAt,_tmpUpdatedAt);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getSessionByIdSync(final String sessionId,
      final Continuation<? super CareSession> $completion) {
    final String _sql = "SELECT * FROM care_sessions WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (sessionId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, sessionId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<CareSession>() {
      @Override
      @Nullable
      public CareSession call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfChildId = CursorUtil.getColumnIndexOrThrow(_cursor, "childId");
          final int _cursorIndexOfCheckInTime = CursorUtil.getColumnIndexOrThrow(_cursor, "checkInTime");
          final int _cursorIndexOfCheckOutTime = CursorUtil.getColumnIndexOrThrow(_cursor, "checkOutTime");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final CareSession _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpChildId;
            if (_cursor.isNull(_cursorIndexOfChildId)) {
              _tmpChildId = null;
            } else {
              _tmpChildId = _cursor.getString(_cursorIndexOfChildId);
            }
            final long _tmpCheckInTime;
            _tmpCheckInTime = _cursor.getLong(_cursorIndexOfCheckInTime);
            final Long _tmpCheckOutTime;
            if (_cursor.isNull(_cursorIndexOfCheckOutTime)) {
              _tmpCheckOutTime = null;
            } else {
              _tmpCheckOutTime = _cursor.getLong(_cursorIndexOfCheckOutTime);
            }
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _result = new CareSession(_tmpId,_tmpChildId,_tmpCheckInTime,_tmpCheckOutTime,_tmpNotes,_tmpCreatedAt,_tmpUpdatedAt);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<CareSession> getActiveSessionForChild(final String childId) {
    final String _sql = "SELECT * FROM care_sessions WHERE childId = ? AND checkOutTime IS NULL LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (childId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, childId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"care_sessions"}, new Callable<CareSession>() {
      @Override
      @Nullable
      public CareSession call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfChildId = CursorUtil.getColumnIndexOrThrow(_cursor, "childId");
          final int _cursorIndexOfCheckInTime = CursorUtil.getColumnIndexOrThrow(_cursor, "checkInTime");
          final int _cursorIndexOfCheckOutTime = CursorUtil.getColumnIndexOrThrow(_cursor, "checkOutTime");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final CareSession _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpChildId;
            if (_cursor.isNull(_cursorIndexOfChildId)) {
              _tmpChildId = null;
            } else {
              _tmpChildId = _cursor.getString(_cursorIndexOfChildId);
            }
            final long _tmpCheckInTime;
            _tmpCheckInTime = _cursor.getLong(_cursorIndexOfCheckInTime);
            final Long _tmpCheckOutTime;
            if (_cursor.isNull(_cursorIndexOfCheckOutTime)) {
              _tmpCheckOutTime = null;
            } else {
              _tmpCheckOutTime = _cursor.getLong(_cursorIndexOfCheckOutTime);
            }
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _result = new CareSession(_tmpId,_tmpChildId,_tmpCheckInTime,_tmpCheckOutTime,_tmpNotes,_tmpCreatedAt,_tmpUpdatedAt);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getActiveSessionForChildSync(final String childId,
      final Continuation<? super CareSession> $completion) {
    final String _sql = "SELECT * FROM care_sessions WHERE childId = ? AND checkOutTime IS NULL LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (childId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, childId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<CareSession>() {
      @Override
      @Nullable
      public CareSession call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfChildId = CursorUtil.getColumnIndexOrThrow(_cursor, "childId");
          final int _cursorIndexOfCheckInTime = CursorUtil.getColumnIndexOrThrow(_cursor, "checkInTime");
          final int _cursorIndexOfCheckOutTime = CursorUtil.getColumnIndexOrThrow(_cursor, "checkOutTime");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final CareSession _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpChildId;
            if (_cursor.isNull(_cursorIndexOfChildId)) {
              _tmpChildId = null;
            } else {
              _tmpChildId = _cursor.getString(_cursorIndexOfChildId);
            }
            final long _tmpCheckInTime;
            _tmpCheckInTime = _cursor.getLong(_cursorIndexOfCheckInTime);
            final Long _tmpCheckOutTime;
            if (_cursor.isNull(_cursorIndexOfCheckOutTime)) {
              _tmpCheckOutTime = null;
            } else {
              _tmpCheckOutTime = _cursor.getLong(_cursorIndexOfCheckOutTime);
            }
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _result = new CareSession(_tmpId,_tmpChildId,_tmpCheckInTime,_tmpCheckOutTime,_tmpNotes,_tmpCreatedAt,_tmpUpdatedAt);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<CareSession>> getAllActiveSessions() {
    final String _sql = "SELECT * FROM care_sessions WHERE checkOutTime IS NULL";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"care_sessions"}, new Callable<List<CareSession>>() {
      @Override
      @NonNull
      public List<CareSession> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfChildId = CursorUtil.getColumnIndexOrThrow(_cursor, "childId");
          final int _cursorIndexOfCheckInTime = CursorUtil.getColumnIndexOrThrow(_cursor, "checkInTime");
          final int _cursorIndexOfCheckOutTime = CursorUtil.getColumnIndexOrThrow(_cursor, "checkOutTime");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<CareSession> _result = new ArrayList<CareSession>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final CareSession _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpChildId;
            if (_cursor.isNull(_cursorIndexOfChildId)) {
              _tmpChildId = null;
            } else {
              _tmpChildId = _cursor.getString(_cursorIndexOfChildId);
            }
            final long _tmpCheckInTime;
            _tmpCheckInTime = _cursor.getLong(_cursorIndexOfCheckInTime);
            final Long _tmpCheckOutTime;
            if (_cursor.isNull(_cursorIndexOfCheckOutTime)) {
              _tmpCheckOutTime = null;
            } else {
              _tmpCheckOutTime = _cursor.getLong(_cursorIndexOfCheckOutTime);
            }
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _item = new CareSession(_tmpId,_tmpChildId,_tmpCheckInTime,_tmpCheckOutTime,_tmpNotes,_tmpCreatedAt,_tmpUpdatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<CareSession>> getSessionsByChildIdAndDateRange(final String childId,
      final long startTime, final long endTime) {
    final String _sql = "\n"
            + "        SELECT * FROM care_sessions \n"
            + "        WHERE childId = ? \n"
            + "        AND checkInTime >= ? \n"
            + "        AND checkInTime <= ? \n"
            + "        ORDER BY checkInTime ASC\n"
            + "    ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (childId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, childId);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, startTime);
    _argIndex = 3;
    _statement.bindLong(_argIndex, endTime);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"care_sessions"}, new Callable<List<CareSession>>() {
      @Override
      @NonNull
      public List<CareSession> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfChildId = CursorUtil.getColumnIndexOrThrow(_cursor, "childId");
          final int _cursorIndexOfCheckInTime = CursorUtil.getColumnIndexOrThrow(_cursor, "checkInTime");
          final int _cursorIndexOfCheckOutTime = CursorUtil.getColumnIndexOrThrow(_cursor, "checkOutTime");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<CareSession> _result = new ArrayList<CareSession>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final CareSession _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpChildId;
            if (_cursor.isNull(_cursorIndexOfChildId)) {
              _tmpChildId = null;
            } else {
              _tmpChildId = _cursor.getString(_cursorIndexOfChildId);
            }
            final long _tmpCheckInTime;
            _tmpCheckInTime = _cursor.getLong(_cursorIndexOfCheckInTime);
            final Long _tmpCheckOutTime;
            if (_cursor.isNull(_cursorIndexOfCheckOutTime)) {
              _tmpCheckOutTime = null;
            } else {
              _tmpCheckOutTime = _cursor.getLong(_cursorIndexOfCheckOutTime);
            }
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _item = new CareSession(_tmpId,_tmpChildId,_tmpCheckInTime,_tmpCheckOutTime,_tmpNotes,_tmpCreatedAt,_tmpUpdatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getSessionsByChildIdAndDateRangeSync(final String childId, final long startTime,
      final long endTime, final Continuation<? super List<CareSession>> $completion) {
    final String _sql = "\n"
            + "        SELECT * FROM care_sessions \n"
            + "        WHERE childId = ? \n"
            + "        AND checkInTime >= ? \n"
            + "        AND checkInTime <= ? \n"
            + "        ORDER BY checkInTime ASC\n"
            + "    ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (childId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, childId);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, startTime);
    _argIndex = 3;
    _statement.bindLong(_argIndex, endTime);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<CareSession>>() {
      @Override
      @NonNull
      public List<CareSession> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfChildId = CursorUtil.getColumnIndexOrThrow(_cursor, "childId");
          final int _cursorIndexOfCheckInTime = CursorUtil.getColumnIndexOrThrow(_cursor, "checkInTime");
          final int _cursorIndexOfCheckOutTime = CursorUtil.getColumnIndexOrThrow(_cursor, "checkOutTime");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<CareSession> _result = new ArrayList<CareSession>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final CareSession _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpChildId;
            if (_cursor.isNull(_cursorIndexOfChildId)) {
              _tmpChildId = null;
            } else {
              _tmpChildId = _cursor.getString(_cursorIndexOfChildId);
            }
            final long _tmpCheckInTime;
            _tmpCheckInTime = _cursor.getLong(_cursorIndexOfCheckInTime);
            final Long _tmpCheckOutTime;
            if (_cursor.isNull(_cursorIndexOfCheckOutTime)) {
              _tmpCheckOutTime = null;
            } else {
              _tmpCheckOutTime = _cursor.getLong(_cursorIndexOfCheckOutTime);
            }
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _item = new CareSession(_tmpId,_tmpChildId,_tmpCheckInTime,_tmpCheckOutTime,_tmpNotes,_tmpCreatedAt,_tmpUpdatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<CareSession>> getSessionsByDateRange(final long startTime, final long endTime) {
    final String _sql = "\n"
            + "        SELECT * FROM care_sessions \n"
            + "        WHERE checkInTime >= ? \n"
            + "        AND checkInTime <= ? \n"
            + "        ORDER BY checkInTime DESC\n"
            + "    ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, startTime);
    _argIndex = 2;
    _statement.bindLong(_argIndex, endTime);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"care_sessions"}, new Callable<List<CareSession>>() {
      @Override
      @NonNull
      public List<CareSession> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfChildId = CursorUtil.getColumnIndexOrThrow(_cursor, "childId");
          final int _cursorIndexOfCheckInTime = CursorUtil.getColumnIndexOrThrow(_cursor, "checkInTime");
          final int _cursorIndexOfCheckOutTime = CursorUtil.getColumnIndexOrThrow(_cursor, "checkOutTime");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<CareSession> _result = new ArrayList<CareSession>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final CareSession _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpChildId;
            if (_cursor.isNull(_cursorIndexOfChildId)) {
              _tmpChildId = null;
            } else {
              _tmpChildId = _cursor.getString(_cursorIndexOfChildId);
            }
            final long _tmpCheckInTime;
            _tmpCheckInTime = _cursor.getLong(_cursorIndexOfCheckInTime);
            final Long _tmpCheckOutTime;
            if (_cursor.isNull(_cursorIndexOfCheckOutTime)) {
              _tmpCheckOutTime = null;
            } else {
              _tmpCheckOutTime = _cursor.getLong(_cursorIndexOfCheckOutTime);
            }
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _item = new CareSession(_tmpId,_tmpChildId,_tmpCheckInTime,_tmpCheckOutTime,_tmpNotes,_tmpCreatedAt,_tmpUpdatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<Float> getTotalHoursForChild(final String childId) {
    final String _sql = "\n"
            + "        SELECT SUM(\n"
            + "            CASE \n"
            + "                WHEN checkOutTime IS NOT NULL THEN (checkOutTime - checkInTime) \n"
            + "                ELSE 0 \n"
            + "            END\n"
            + "        ) / 3600000.0 \n"
            + "        FROM care_sessions \n"
            + "        WHERE childId = ?\n"
            + "    ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (childId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, childId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"care_sessions"}, new Callable<Float>() {
      @Override
      @Nullable
      public Float call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Float _result;
          if (_cursor.moveToFirst()) {
            final Float _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getFloat(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<Float> getTotalHoursForChildInRange(final String childId, final long startTime,
      final long endTime) {
    final String _sql = "\n"
            + "        SELECT SUM(\n"
            + "            CASE \n"
            + "                WHEN checkOutTime IS NOT NULL THEN (checkOutTime - checkInTime) \n"
            + "                ELSE 0 \n"
            + "            END\n"
            + "        ) / 3600000.0 \n"
            + "        FROM care_sessions \n"
            + "        WHERE childId = ? \n"
            + "        AND checkInTime >= ? \n"
            + "        AND checkInTime <= ?\n"
            + "    ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (childId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, childId);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, startTime);
    _argIndex = 3;
    _statement.bindLong(_argIndex, endTime);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"care_sessions"}, new Callable<Float>() {
      @Override
      @Nullable
      public Float call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Float _result;
          if (_cursor.moveToFirst()) {
            final Float _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getFloat(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<Integer> getSessionCountForChild(final String childId) {
    final String _sql = "SELECT COUNT(*) FROM care_sessions WHERE childId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (childId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, childId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"care_sessions"}, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
