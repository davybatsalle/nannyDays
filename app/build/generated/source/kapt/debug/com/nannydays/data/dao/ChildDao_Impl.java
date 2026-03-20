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
import com.nannydays.data.model.Child;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
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
public final class ChildDao_Impl implements ChildDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Child> __insertionAdapterOfChild;

  private final EntityDeletionOrUpdateAdapter<Child> __deletionAdapterOfChild;

  private final EntityDeletionOrUpdateAdapter<Child> __updateAdapterOfChild;

  private final SharedSQLiteStatement __preparedStmtOfDeleteChildById;

  public ChildDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfChild = new EntityInsertionAdapter<Child>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `children` (`id`,`name`,`dateOfBirth`,`standardHoursPerWeek`,`parentName`,`parentContact`,`notes`,`createdAt`,`updatedAt`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Child entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        statement.bindLong(3, entity.getDateOfBirth());
        statement.bindDouble(4, entity.getStandardHoursPerWeek());
        if (entity.getParentName() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getParentName());
        }
        if (entity.getParentContact() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getParentContact());
        }
        if (entity.getNotes() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getNotes());
        }
        statement.bindLong(8, entity.getCreatedAt());
        statement.bindLong(9, entity.getUpdatedAt());
      }
    };
    this.__deletionAdapterOfChild = new EntityDeletionOrUpdateAdapter<Child>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `children` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Child entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
      }
    };
    this.__updateAdapterOfChild = new EntityDeletionOrUpdateAdapter<Child>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `children` SET `id` = ?,`name` = ?,`dateOfBirth` = ?,`standardHoursPerWeek` = ?,`parentName` = ?,`parentContact` = ?,`notes` = ?,`createdAt` = ?,`updatedAt` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Child entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        statement.bindLong(3, entity.getDateOfBirth());
        statement.bindDouble(4, entity.getStandardHoursPerWeek());
        if (entity.getParentName() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getParentName());
        }
        if (entity.getParentContact() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getParentContact());
        }
        if (entity.getNotes() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getNotes());
        }
        statement.bindLong(8, entity.getCreatedAt());
        statement.bindLong(9, entity.getUpdatedAt());
        if (entity.getId() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getId());
        }
      }
    };
    this.__preparedStmtOfDeleteChildById = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM children WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertChild(final Child child, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfChild.insert(child);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteChild(final Child child, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfChild.handle(child);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateChild(final Child child, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfChild.handle(child);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteChildById(final String childId,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteChildById.acquire();
        int _argIndex = 1;
        if (childId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, childId);
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
          __preparedStmtOfDeleteChildById.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Child>> getAllChildren() {
    final String _sql = "SELECT * FROM children ORDER BY name ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"children"}, new Callable<List<Child>>() {
      @Override
      @NonNull
      public List<Child> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDateOfBirth = CursorUtil.getColumnIndexOrThrow(_cursor, "dateOfBirth");
          final int _cursorIndexOfStandardHoursPerWeek = CursorUtil.getColumnIndexOrThrow(_cursor, "standardHoursPerWeek");
          final int _cursorIndexOfParentName = CursorUtil.getColumnIndexOrThrow(_cursor, "parentName");
          final int _cursorIndexOfParentContact = CursorUtil.getColumnIndexOrThrow(_cursor, "parentContact");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<Child> _result = new ArrayList<Child>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Child _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final long _tmpDateOfBirth;
            _tmpDateOfBirth = _cursor.getLong(_cursorIndexOfDateOfBirth);
            final float _tmpStandardHoursPerWeek;
            _tmpStandardHoursPerWeek = _cursor.getFloat(_cursorIndexOfStandardHoursPerWeek);
            final String _tmpParentName;
            if (_cursor.isNull(_cursorIndexOfParentName)) {
              _tmpParentName = null;
            } else {
              _tmpParentName = _cursor.getString(_cursorIndexOfParentName);
            }
            final String _tmpParentContact;
            if (_cursor.isNull(_cursorIndexOfParentContact)) {
              _tmpParentContact = null;
            } else {
              _tmpParentContact = _cursor.getString(_cursorIndexOfParentContact);
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
            _item = new Child(_tmpId,_tmpName,_tmpDateOfBirth,_tmpStandardHoursPerWeek,_tmpParentName,_tmpParentContact,_tmpNotes,_tmpCreatedAt,_tmpUpdatedAt);
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
  public Flow<Child> getChildById(final String childId) {
    final String _sql = "SELECT * FROM children WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (childId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, childId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"children"}, new Callable<Child>() {
      @Override
      @Nullable
      public Child call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDateOfBirth = CursorUtil.getColumnIndexOrThrow(_cursor, "dateOfBirth");
          final int _cursorIndexOfStandardHoursPerWeek = CursorUtil.getColumnIndexOrThrow(_cursor, "standardHoursPerWeek");
          final int _cursorIndexOfParentName = CursorUtil.getColumnIndexOrThrow(_cursor, "parentName");
          final int _cursorIndexOfParentContact = CursorUtil.getColumnIndexOrThrow(_cursor, "parentContact");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final Child _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final long _tmpDateOfBirth;
            _tmpDateOfBirth = _cursor.getLong(_cursorIndexOfDateOfBirth);
            final float _tmpStandardHoursPerWeek;
            _tmpStandardHoursPerWeek = _cursor.getFloat(_cursorIndexOfStandardHoursPerWeek);
            final String _tmpParentName;
            if (_cursor.isNull(_cursorIndexOfParentName)) {
              _tmpParentName = null;
            } else {
              _tmpParentName = _cursor.getString(_cursorIndexOfParentName);
            }
            final String _tmpParentContact;
            if (_cursor.isNull(_cursorIndexOfParentContact)) {
              _tmpParentContact = null;
            } else {
              _tmpParentContact = _cursor.getString(_cursorIndexOfParentContact);
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
            _result = new Child(_tmpId,_tmpName,_tmpDateOfBirth,_tmpStandardHoursPerWeek,_tmpParentName,_tmpParentContact,_tmpNotes,_tmpCreatedAt,_tmpUpdatedAt);
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
  public Object getChildByIdSync(final String childId,
      final Continuation<? super Child> $completion) {
    final String _sql = "SELECT * FROM children WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (childId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, childId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Child>() {
      @Override
      @Nullable
      public Child call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDateOfBirth = CursorUtil.getColumnIndexOrThrow(_cursor, "dateOfBirth");
          final int _cursorIndexOfStandardHoursPerWeek = CursorUtil.getColumnIndexOrThrow(_cursor, "standardHoursPerWeek");
          final int _cursorIndexOfParentName = CursorUtil.getColumnIndexOrThrow(_cursor, "parentName");
          final int _cursorIndexOfParentContact = CursorUtil.getColumnIndexOrThrow(_cursor, "parentContact");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final Child _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final long _tmpDateOfBirth;
            _tmpDateOfBirth = _cursor.getLong(_cursorIndexOfDateOfBirth);
            final float _tmpStandardHoursPerWeek;
            _tmpStandardHoursPerWeek = _cursor.getFloat(_cursorIndexOfStandardHoursPerWeek);
            final String _tmpParentName;
            if (_cursor.isNull(_cursorIndexOfParentName)) {
              _tmpParentName = null;
            } else {
              _tmpParentName = _cursor.getString(_cursorIndexOfParentName);
            }
            final String _tmpParentContact;
            if (_cursor.isNull(_cursorIndexOfParentContact)) {
              _tmpParentContact = null;
            } else {
              _tmpParentContact = _cursor.getString(_cursorIndexOfParentContact);
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
            _result = new Child(_tmpId,_tmpName,_tmpDateOfBirth,_tmpStandardHoursPerWeek,_tmpParentName,_tmpParentContact,_tmpNotes,_tmpCreatedAt,_tmpUpdatedAt);
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
  public Flow<Integer> getChildCount() {
    final String _sql = "SELECT COUNT(*) FROM children";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"children"}, new Callable<Integer>() {
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
