package ir.mohsenafshar.android.movies.data.db;

import android.support.annotation.NonNull;
import android.util.Log;

import io.realm.DynamicRealm;
import io.realm.DynamicRealmObject;
import io.realm.FieldAttribute;
import io.realm.RealmMigration;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;
import ir.mohsenafshar.android.movies.data.pojo.MovieFields;


public class Migration implements RealmMigration {

    private static final String TAG = RealmMigration.class.getCanonicalName();

    @Override
    public void migrate(@NonNull DynamicRealm realm, long oldVersion, long newVersion) {

    }

    /*
    *
    * SAMPLE IMPLEMENTATION OF MIGRATION
    *
    * */
    /*private int rank = 1;

    @Override
    public void migrate(@NonNull final DynamicRealm realm, long oldVersion, long newVersion) {
        RealmSchema realmSchema = realm.getSchema();

        Log.d(TAG, "migrate: " + oldVersion + " , " + newVersion);
        RealmObjectSchema movieSchema = realmSchema.get("Movie");

        if(oldVersion == 1){
            movieSchema.addField(MovieFields._ID, Integer.class, FieldAttribute.PRIMARY_KEY)
                    .transform(new RealmObjectSchema.Function() {
                        @Override
                        public void apply(DynamicRealmObject obj) {

                            obj.set(MovieFields._ID, rank);
                            rank += 1;
                        }
                    });

        }
        else if(oldVersion == 2){
            movieSchema.addPrimaryKey(MovieFields._ID);
        }
    }*/
}
