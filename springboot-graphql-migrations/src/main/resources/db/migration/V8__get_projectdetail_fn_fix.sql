---------------------------------------------------------------------------------------------------------
-- Author       Patrik Duch
-- Purpose      Get projectdetail PLpgSQL function fix.
---------------------------------------------------------------------------------------------------------
DO $$ -- IF function already exists we must drop it
BEGIN

	IF EXISTS (
		SELECT format('%I.%I(%s)', ns.nspname, p.proname, oidvectortypes(p.proargtypes)), P.proname
		FROM pg_proc p INNER JOIN pg_namespace ns ON (p.pronamespace = ns.oid)
		WHERE P.proname = 'get_projectdetail_fn') THEN

            DROP FUNCTION springboot_graphql.get_projectdetail_fn;
    END IF;

END;
$$;

DO $_$ -- Function creation
BEGIN
    BEGIN
        CREATE FUNCTION get_projectdetail_fn() RETURNS TABLE(
            project_name VARCHAR
        )  AS $$

        BEGIN
            RETURN QUERY
                SELECT p.name FROM springboot_graphql.projectdetail p
                ORDER BY p.id DESC LIMIT 1;
        END
        $$ LANGUAGE plpgsql;
    END;
END $_$;