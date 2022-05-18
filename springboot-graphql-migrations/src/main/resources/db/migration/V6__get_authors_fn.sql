---------------------------------------------------------------------------------------------------------
-- Author       Patrik Duch
-- Purpose      Fetch list of authors.
---------------------------------------------------------------------------------------------------------
DO $$ -- IF function already exists we must drop it
BEGIN
	IF EXISTS (
		SELECT format('%I.%I(%s)', ns.nspname, p.proname, oidvectortypes(p.proargtypes)), P.proname
		FROM pg_proc p INNER JOIN pg_namespace ns ON (p.pronamespace = ns.oid)
		WHERE P.proname = 'get_authors_fn') THEN

            DROP FUNCTION get_authors_fn;

    END IF;
END;
$$;

DO $_$ -- Function creation
BEGIN
    BEGIN
        CREATE OR REPLACE FUNCTION get_authors_fn() RETURNS TABLE(
            id UUID,
            name VARCHAR,
            email TEXT
        )  AS $$
            BEGIN
                RETURN QUERY
                    SELECT a.id, a."name", a.email from author a;
            END
            $$ LANGUAGE plpgsql;
    END;
END $_$;